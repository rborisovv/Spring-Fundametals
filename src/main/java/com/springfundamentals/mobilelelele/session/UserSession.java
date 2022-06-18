package com.springfundamentals.mobilelelele.session;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserSession {
    private Long id;

    private boolean isLoggedIn;

    private String username;
}