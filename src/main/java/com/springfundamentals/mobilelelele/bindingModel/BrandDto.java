package com.springfundamentals.mobilelelele.bindingModel;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BrandDto {
    @NotBlank
    private String name;

    @NotNull
    private Set<ModelDto> models;
}