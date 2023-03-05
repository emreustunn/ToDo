package com.emre.dto.response;

import com.emre.repository.entity.enums.EState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskFindAllByUserIdResponseDtos {
    Long id;
    String name;
    String description;
    EState state;


}
