package kr.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.dao.OfferDAO;
import kr.ac.model.Offer;

@Service
public class OfferService {
	
	@Autowired
	private OfferDAO offerDao;
	
	public List<Offer> getCurrent() {
		
		return offerDao.getOffers();
	}
	
	
	// 년도 + 학기 정보
	public List<Offer> getYear() {
		
		return offerDao.getyears();
	}
	
	
	//학점내역
	public List<Offer> getDetails() {
		
		return offerDao.getDetail();
	}
	
	
	// 해당 년도+학기를 토대로 수강과목들 가져옴
	public List<Offer> getLink(int year, int term){
		
		//return (List<Offer>)offerDao.getLink(offers);
		return offerDao.getLinks(year, term);
	}
	
	// 2018년도 1학기 정보를 가져오는 부분
	public List<Offer> getFuture() {
			
		return offerDao.getFutures();
	}
	
	
	// 데이터 추가 시키는 부분
	public void insert(Offer offer) {
		offerDao.insert(offer);
		
	}
	
	
	

}
