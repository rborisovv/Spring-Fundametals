package com.springfundamentals.mobilelelele.model;

import com.springfundamentals.mobilelelele.enumeration.Category;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "models")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Model extends BaseEntity {
    @Column
    @NonNull
    private String name;

    @Enumerated(EnumType.STRING)
    @NonNull
    private Category category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    @NonNull
    private Integer startYear;

    @Column
    private Integer endYear;

    @ManyToOne
    private Brand brand;
}