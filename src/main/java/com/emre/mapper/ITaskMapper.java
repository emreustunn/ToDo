package com.emre.mapper;

import com.emre.dto.request.TaskSaveRequestDto;
import com.emre.dto.response.TaskFindAllByUserIdResponseDtos;
import com.emre.repository.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITaskMapper {

    ITaskMapper INSTANCE = Mappers.getMapper(ITaskMapper.class);

    Task fromTaskSaveRequestDto(final TaskSaveRequestDto dto);
    TaskFindAllByUserIdResponseDtos fromTask(final Task task);


}
