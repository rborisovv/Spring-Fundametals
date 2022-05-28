package com.springfundamentals.mobilelelele.model;

import com.springfundamentals.mobilelelele.enumeration.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private Role role;
}