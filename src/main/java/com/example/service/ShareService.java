package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Share;
import com.example.repository.ShareRepository;

@Service
public class ShareService {

	@Autowired
	ShareRepository shareRepository;
	
	public List<Share> getAllShare() {
		List<Share> share = new ArrayList<Share>();
		shareRepository.findAll().forEach(share1 -> share.add(share1));
		return share;
	}

	public Share getShareById(int id) {
		return shareRepository.findById(id).get();
	}
	
	public Share getShare(String loginId) {
		return shareRepository.findByName(loginId).get();
	}

	public void saveOrUpdate(Share share) {
		shareRepository.save(share);
	}

	public void delete(int id) {
		shareRepository.deleteById(id);
	}

	public void update(Share share, int shareno) {
		shareRepository.save(share);
	}
}
