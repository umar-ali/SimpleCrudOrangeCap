package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.OrderLedger;
import com.example.repository.OrderLedgerRepository;

@Service
public class OrderLedgerService {

	@Autowired
	OrderLedgerRepository orderLedgerRepository;
	
	@Autowired
	ShareService shareService;
	
	public List<OrderLedger> getAllOrderLedger() {
		List<OrderLedger> orderLedger = new ArrayList<>();
		orderLedgerRepository.findAll().forEach(ol-> orderLedger.add(ol));
		return orderLedger;
	}
	
	public  List<OrderLedger> get(String loginId) {
		Optional<List<OrderLedger>> orderLedger = orderLedgerRepository.findByLoginId(loginId);
		return orderLedger.get();
	}
	
	
	public List<String> getShareListByLoginId(String loginId){
		List<String> lis =  get(loginId).stream().map(i->i.getShare()).distinct().toList();
		return lis;
	}
	
	public List<OrderLedger> getByLoginIdAndShare(String loginId, String share){
		return orderLedgerRepository.findByLoginIdAndShare(loginId, share).get();
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
