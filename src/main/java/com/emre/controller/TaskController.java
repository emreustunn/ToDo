package com.emre.controller;

import com.emre.dto.request.TaskSaveRequestDto;
import com.emre.dto.response.TaskFindAllByUserIdResponseDtos;
import com.emre.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.emre.constants.EndPoints.*;
@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    //Yeni bir task kayıt eder
    @GetMapping(SAVE)
    public ResponseEntity<String> save(TaskSaveRequestDto dto){
        taskService.saveDto(dto);
        return ResponseEntity.ok("Ok.");
    }
    //Taskın durumunu done yapar.
    @GetMapping(DO_DONE)
    public void doDoneTaskState(Long taskId){
        taskService.doDoneTaskState(taskId);
    }

    //Taskın durumunu canceled yapar.
    @GetMapping(DO_CANCELED)
    public void doCanceledTaskState(Long taskId){
        taskService.doCancaledTaskState(taskId);
    }

    //Taskın durumunu tekrardan to-do yapar.
    @GetMapping(TO_DO)
    public void doToDoTaskState(Long taskId){
        taskService.doToDoTaskState(taskId);
    }

    //Girilen User id'ye göre tüm kayıtlı taskları getirir.
    @PostMapping(GETALLTASKSBYID)
    public ResponseEntity<List<TaskFindAllByUserIdResponseDtos>> findAllTasksById(Long id){
        return ResponseEntity.ok(taskService.findAllByIdResponseDtos(id));
    }
}
