package com.springfundamentals.mobilelelele.service;

import com.springfundamentals.mobilelelele.bindingModel.OfferDto;
import com.springfundamentals.mobilelelele.config.mapper.OfferDtoToOfferMapper;
import com.springfundamentals.mobilelelele.config.mapper.OfferToOfferDtoMapper;
import com.springfundamentals.mobilelelele.dao.OfferRepository;
import com.springfundamentals.mobilelelele.model.Offer;
import com.springfundamentals.mobilelelele.model.User;
import com.springfundamentals.mobilelelele.session.UserSession;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferService {
    private final UserService userService;
    private final ModelService modelService;
    private final OfferRepository offerRepository;
    private final OfferToOfferDtoMapper offerDtoMapper;
    private final OfferDtoToOfferMapper offerMapper;
    private final UserSession userSession;

    public OfferService(UserService userService, ModelService modelService, OfferRepository offerRepository, OfferToOfferDtoMapper offerDtoMapper, OfferDtoToOfferMapper offerMapper, UserSession userSession) {
        this.userService = userService;
        this.modelService = modelService;
        this.offerRepository = offerRepository;
        this.offerDtoMapper = offerDtoMapper;
        this.offerMapper = offerMapper;
        this.userSession = userSession;
    }

    public List<OfferDto> getAllOffers() {
        return this.offerRepository.findAll()
                .stream()
                .map(offerDtoMapper::offerMapper)
                .collect(Collectors.toList());
    }

    public void addOffer(OfferDto offerModel) {
        Offer offerEntity = this.offerMapper.mapToOffer(offerModel);
        User user = this.userService.findUserById(userSession.getId());
        offerEntity.setUser(user);
        offerEntity.setModel(this.modelService.getModelById(offerModel.getModelId()));
        offerEntity.setCreated(LocalDateTime.now());
        offerEntity.setModified(LocalDateTime.now());

        this.offerRepository.save(offerEntity);
    }
}