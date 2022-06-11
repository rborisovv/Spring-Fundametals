package com.springfundamentals.mobilelelele.service;

import com.springfundamentals.mobilelelele.dao.UserRepository;
import com.springfundamentals.mobilelelele.bindingModel.UserLoginDto;
import com.springfundamentals.mobilelelele.bindingModel.UserRegisterDto;
import com.springfundamentals.mobilelelele.model.User;
import com.springfundamentals.mobilelelele.session.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;
    private final ModelMapper modelMapper;

    private static final String UNSUCCESSFUL_LOGIN_MESSAGE = "Username or password is incorrect!";

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserSession userSession, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
        this.modelMapper = modelMapper;
    }

    private boolean isUserPresent(String username) {
        return this.userRepository.findByUsername(username).isPresent();
    }

    public void registerUser(UserRegisterDto userRegisterDto) {
        String username = userRegisterDto.getUsername();
        if (isUserPresent(username)) {
            log.info(String.format("User with username %s already registered!", username));
            return;
        }

        User userEntity = modelMapper.map(userRegisterDto, User.class);
        userEntity.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        this.userRepository.save(userEntity);
        bindSessionFields(username);
    }

    public void loginUser(UserLoginDto userLoginDto) {
        String username = userLoginDto.getUsername();
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            log.info(UNSUCCESSFUL_LOGIN_MESSAGE);
            return;
        }

        User userEntity = optionalUser.get();
        if (!passwordEncoder.matches(userLoginDto.getPassword(), userEntity.getPassword())) {
            log.info(UNSUCCESSFUL_LOGIN_MESSAGE);
            return;
        }
        bindSessionFields(username);
    }

    private void bindSessionFields(String username) {
        userSession.setLoggedIn(true);
        userSession.setUsername(username);
    }
}