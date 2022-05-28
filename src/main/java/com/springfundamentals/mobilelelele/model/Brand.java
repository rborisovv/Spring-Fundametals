package com.springfundamentals.mobilelelele.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}