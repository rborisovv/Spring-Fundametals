package com.springfundamentals.mobilelelele.config.mapper;

import com.springfundamentals.mobilelelele.bindingModel.OfferDto;
import com.springfundamentals.mobilelelele.model.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface OfferDtoToOfferMapper {
    Offer mapToOffer(OfferDto offerDto);
}