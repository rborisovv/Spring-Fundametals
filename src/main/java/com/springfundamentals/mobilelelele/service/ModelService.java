package com.springfundamentals.mobilelelele.service;

import com.springfundamentals.mobilelelele.dao.ModelRepository;
import com.springfundamentals.mobilelelele.model.Model;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Model getModelById(Long id) {
        return this.modelRepository.getById(id);
    }
}