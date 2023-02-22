package com.wor.demo.bodyPart.repository;

import org.springframework.data.repository.CrudRepository;

import com.wor.demo.bodyPart.domain.BodyPart;

public interface BodyPartRepository extends CrudRepository<BodyPart, Integer> {
    BodyPart findByName(String name);
}
