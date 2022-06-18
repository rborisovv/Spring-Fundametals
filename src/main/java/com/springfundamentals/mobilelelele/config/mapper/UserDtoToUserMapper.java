package com.springfundamentals.mobilelelele.config.mapper;


import com.springfundamentals.mobilelelele.bindingModel.UserRegisterDto;
import com.springfundamentals.mobilelelele.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface UserDtoToUserMapper {
    User userRegisterMapper(UserRegisterDto userRegisterDto);
}