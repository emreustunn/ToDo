package com.emre.controller;

import com.emre.dto.request.UserLoginRequestDto;
import com.emre.dto.request.UserSaveRequestDto;
import com.emre.dto.response.UserFindAllResponseDto;
import com.emre.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.emre.constants.EndPoints.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //Yeni bir kullanıcı kayıt eder.
    @GetMapping(SAVE)
    public ResponseEntity<String> save(UserSaveRequestDto dto){
        userService.saveDto(dto);
        return ResponseEntity.ok("Ok.");
    }
    //Userin kullanıcı adi ve şifresi doğru mu diye kontrol eder.
    @GetMapping(LOGIN)
    public Boolean doLogin(UserLoginRequestDto dto){
        return userService.doLogin(dto);
    }

    //Databasede kayıtlı olan bütün kullanıcıları getirir.
    @PostMapping(GETALL)
    public ResponseEntity<List<UserFindAllResponseDto>> findAll(){
        return ResponseEntity.ok(userService.findAllResponseDtos());
    }
}
