package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.OrderLedger;
import com.example.repository.OrderLedgerRepository;

@Service
public class OrderLedgerService {

	@Autowired
	OrderLedgerRepository orderLedgerRepository;
	
	public List<OrderLedger> getAllOrderLedger() {
		List<OrderLedger> orderLedger = new ArrayList<>();
		orderLedgerRepository.findAll().forEach(ol-> orderLedger.add(ol));
		System.out.println();
		return orderLedger;
	}
	
	public  OrderLedger get(String loginId) {
		Optional<OrderLedger> orderLedger = orderLedgerRepository.findByLoginId(loginId);
		return orderLedger.get();
	}

	public OrderLedger getOrderLedgerById(int id) {
		return orderLedgerRepository.findById(id).get();
	}

	public void saveOrUpdate(OrderLedger orderLedger) {
		orderLedgerRepository.save(orderLedger);
	}

	public void delete(int id) {
		orderLedgerRepository.deleteById(id);
	}

	public void update(OrderLedger orderLedger, int orderLedgerno) {
		orderLedgerRepository.save(orderLedger);
	}
}
