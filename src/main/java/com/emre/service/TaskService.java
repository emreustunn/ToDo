package com.emre.service;

import com.emre.dto.request.TaskSaveRequestDto;
import com.emre.dto.response.TaskFindAllByUserIdResponseDtos;
import com.emre.mapper.ITaskMapper;
import com.emre.repository.ITaskRepository;
import com.emre.repository.entity.Task;
import com.emre.repository.entity.enums.EState;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService extends ServiceManager<Task,Long> {
    private final ITaskRepository repository;
    public TaskService(ITaskRepository repository){
        super(repository);
        this.repository=repository;
    }

    public void saveDto(TaskSaveRequestDto dto) {

        save(ITaskMapper.INSTANCE.fromTaskSaveRequestDto(dto));
    }

    public void doDoneTaskState(Long taskId) {
        Optional<Task> task = repository.findById(taskId);
        if(task.isPresent()) {
            Task updatedTask = task.get();
            updatedTask.setState(EState.DONE);
            repository.save(updatedTask);
        }
    }
    public void doCancaledTaskState(Long taskId) {
        Optional<Task> task = repository.findById(taskId);
        if(task.isPresent()) {
            Task updatedTask = task.get();
            updatedTask.setState(EState.CANCELED);
            repository.save(updatedTask);
        }
    }
    public void doToDoTaskState(Long taskId) {
        Optional<Task> task = repository.findById(taskId);
        if(task.isPresent()) {
            Task updatedTask = task.get();
            updatedTask.setState(EState.TO_DO);
            repository.save(updatedTask);
        }
    }

    public List<TaskFindAllByUserIdResponseDtos> findAllByIdResponseDtos(Long id) {
        List<TaskFindAllByUserIdResponseDtos> result = new ArrayList<>();
        findAll().forEach(x->{
            if (x.getUserId().equals(id))
            result.add(ITaskMapper.INSTANCE.fromTask(x));
        });
        return result;
    }
}
