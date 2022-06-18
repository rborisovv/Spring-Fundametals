package com.springfundamentals.mobilelelele.bindingModel;


import com.springfundamentals.mobilelelele.config.validation.UsernameAvailable;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserRegisterDto {

    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    @NotBlank(message = "Username is required!")
    @Size(min = 2, max = 30, message = "Username must be between 2 and 30 characters!")
    @UsernameAvailable
    private String username;

    @NotBlank
    private String password;
}