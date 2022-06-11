package com.springfundamentals.mobilelelele.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity {
    @Column(unique = true)
    @NonNull
    private String username;

    @Column
    @NonNull
    private String password;

    @Column
    @NonNull
    private String firstName;

    @Column
    @NonNull
    private String lastName;

    @Column
    @NonNull
    private Boolean isActive;

    @ManyToOne
    @NonNull
    private UserRole role;

    @Column(name = "image_url")
    private String imageUrl;
}