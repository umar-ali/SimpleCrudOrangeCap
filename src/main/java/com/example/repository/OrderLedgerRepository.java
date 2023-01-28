package com.example.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.model.OrderLedger;
import com.example.model.User;

public interface OrderLedgerRepository extends CrudRepository<OrderLedger, Integer>{
	Optional<OrderLedger> findByLoginId(String loginId);
}
