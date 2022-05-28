package com.springfundamentals.mobilelelele.model;

import com.springfundamentals.mobilelelele.enumeration.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity{
    @Column
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