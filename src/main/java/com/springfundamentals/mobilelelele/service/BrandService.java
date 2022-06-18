package com.springfundamentals.mobilelelele.service;

import com.springfundamentals.mobilelelele.dao.BrandRepository;
import com.springfundamentals.mobilelelele.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}