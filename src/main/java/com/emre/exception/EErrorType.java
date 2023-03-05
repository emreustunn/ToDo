package com.emre.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum EErrorType {

    USER_NOT_FOUND(1003,"Aradığınız kullanıcı sistemde kayıtlı değildir.",INTERNAL_SERVER_ERROR),
    URUN_EKLEME(2001,"Ürün ekleme başarısız oldu", INTERNAL_SERVER_ERROR),
    METHOD_MIS_MATCH_ERROR(2002,"Giriş yaptığınız değer, istenilen reğerle uyuşmamaktadır",BAD_REQUEST),
    METHOD_NOT_VALID_ARGUMENT_ERROR(2003,"URL içinde eksik parametre gönderimi",BAD_REQUEST),
    INVALID_PARAMATER(3001,"Geçersiz parametre girişi yaptınız.",BAD_REQUEST);


    private int code;
    private String message;
    private HttpStatus httpStatus;
}
