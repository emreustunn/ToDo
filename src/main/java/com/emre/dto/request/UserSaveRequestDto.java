package com.emre.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveRequestDto {
    String name;
    String surname;
    String username;
    String password;
}
