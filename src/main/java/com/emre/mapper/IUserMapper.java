package com.emre.mapper;

import com.emre.dto.request.UserLoginRequestDto;
import com.emre.dto.request.UserSaveRequestDto;
import com.emre.dto.response.UserFindAllResponseDto;
import com.emre.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User fromUserSaveRequestDto(final UserSaveRequestDto dto);
    UserFindAllResponseDto fromUser(final User user);

}
