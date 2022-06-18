package com.springfundamentals.mobilelelele.dao;

import com.springfundamentals.mobilelelele.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}