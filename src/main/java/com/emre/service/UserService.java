package com.emre.service;

import com.emre.dto.request.UserLoginRequestDto;
import com.emre.dto.request.UserSaveRequestDto;
import com.emre.dto.response.UserFindAllResponseDto;
import com.emre.exception.EErrorType;
import com.emre.exception.UserDoLoginException;
import com.emre.mapper.IUserMapper;
import com.emre.repository.IUserRepository;
import com.emre.repository.entity.User;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceManager<User,Long> {
    private final IUserRepository repository;
    public UserService(IUserRepository repository){
        super(repository);
        this.repository = repository;
    }

    public void saveDto(UserSaveRequestDto dto) {
        save(IUserMapper.INSTANCE.fromUserSaveRequestDto(dto));
    }

    public Boolean doLogin(UserLoginRequestDto dto) {
        Optional<User> musteri = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (musteri.isEmpty()){
            throw new UserDoLoginException(EErrorType.USER_NOT_FOUND);
//            return true;
        }
        return true;
    }

    public List<UserFindAllResponseDto> findAllResponseDtos() {
        List<UserFindAllResponseDto> result = new ArrayList<>();
        findAll().forEach(x->{
            result.add(IUserMapper.INSTANCE.fromUser(x));
        });
        return result;
    }
}
