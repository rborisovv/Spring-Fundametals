package com.springfundamentals.mobilelelele.model;

import com.springfundamentals.mobilelelele.enumeration.Engine;
import com.springfundamentals.mobilelelele.enumeration.Transmission;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Offer extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String text;

    @Enumerated(EnumType.STRING)
    private Engine engine;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    @NonNull
    private Integer mileage;

    @Column
    @NonNull
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Column
    private Integer year;

    @ManyToOne
    private Model model;

    @ManyToOne
    private User user;
}