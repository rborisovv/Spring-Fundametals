package com.springfundamentals.mobilelelele.bindingModel;

import com.springfundamentals.mobilelelele.enumeration.Engine;
import com.springfundamentals.mobilelelele.enumeration.Transmission;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OfferDto {
    private Long modelId;

    @Positive
    @NotNull
    private Integer price;

    @NotNull
    private Engine engine;

    @NotNull
    private Transmission transmission;

    @NotNull
    @Positive
    @Min(1900)
    private Integer year;

    @Positive
    @NotNull
    private Integer mileage;

    @NotBlank
    private String text;

    @NotBlank
    private String imageUrl;
}