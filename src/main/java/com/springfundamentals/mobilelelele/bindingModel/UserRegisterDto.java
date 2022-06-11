package com.springfundamentals.mobilelelele.bindingModel;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserRegisterDto {
    private String firstName;

    private String lastName;

    private String username;

    private String password;
}