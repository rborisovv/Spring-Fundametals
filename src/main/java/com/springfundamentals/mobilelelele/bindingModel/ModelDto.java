package com.springfundamentals.mobilelelele.bindingModel;

import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ModelDto {
    @NotBlank
    private String name;
}