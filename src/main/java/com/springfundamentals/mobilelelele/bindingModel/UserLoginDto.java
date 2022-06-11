package com.springfundamentals.mobilelelele.bindingModel;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserLoginDto {
    private String username;

    private String password;
}