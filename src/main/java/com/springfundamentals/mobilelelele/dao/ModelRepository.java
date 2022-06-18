package com.springfundamentals.mobilelelele.dao;

import com.springfundamentals.mobilelelele.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {

}