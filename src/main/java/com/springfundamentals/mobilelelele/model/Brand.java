package com.springfundamentals.mobilelelele.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brands")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Brand extends BaseEntity {
    @Column
    @NonNull
    private String name;

    @OneToMany(mappedBy = "brand",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Model> models;
}