package com.springfundamentals.mobilelelele.config.mapper;

import com.springfundamentals.mobilelelele.bindingModel.OfferDto;
import com.springfundamentals.mobilelelele.model.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface OfferToOfferDtoMapper {
    OfferDto offerMapper(Offer offer);
}