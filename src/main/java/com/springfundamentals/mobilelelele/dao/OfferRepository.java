package com.springfundamentals.mobilelelele.dao;

import com.springfundamentals.mobilelelele.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}