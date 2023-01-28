package com.example.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Share;

public interface ShareRepository extends CrudRepository<Share, Integer>{

	Optional<Share> findByName(String share);

}
