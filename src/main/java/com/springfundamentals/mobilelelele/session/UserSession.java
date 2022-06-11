package com.springfundamentals.mobilelelele.session;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserSession {
    private boolean isLoggedIn;

    private String username;
}