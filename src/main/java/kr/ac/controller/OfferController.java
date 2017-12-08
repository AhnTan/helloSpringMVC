package kr.ac.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.model.Offer;
import kr.ac.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;

	
	@RequestMapping("/link")
	public String showOffers4(@RequestParam("year") int year, @RequestParam("term") int term, Model model) {
		
		List<Offer> offers = offerService.getLink(year, term);
		model.addAttribute("offer", offers);
		
		return "link";
	}
	
	
	@RequestMapping("/check")
	public String showOffers2(Model model) {
		
		
		List<Offer> offers = offerService.getYear();
		model.addAttribute("offer", offers);
		
		
		return "check";
	}
	
	@RequestMapping("/check2")
	public String showOffers3(Model model) {
		List<Offer> offers = offerService.getDetails();
		model.addAttribute("offers", offers);
		
		return "check2";
	}
	
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers", offers);
		
		
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	@RequestMapping("/future")
	public String futureOffer(Model model) {
		
		List<Offer> offer = offerService.getFuture();
		model.addAttribute("offer", offer);
		
		return "future";
	}
	
	@RequestMapping("/docreate")
	public String createOffer(Model model, @Valid Offer offer, BindingResult result) {
		
		// valid로 잘못된 값이 입력(검증을함)되면 오류체크
		if(result.hasErrors()) {
			System.out.println("==Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			// 다시 form이 적용되있는 페이지로 감
			return "createoffer";
		}
		offerService.insert(offer);
		//System.out.println(offer);
		
		return "offercreated";
	}
	
/*	@RequestMapping("/docreate")
	public String createOffer(Model model, @Valid Offer offer, BindingResult result) {
		
		// valid로 잘못된 값이 입력(검증을함)되면 오류체크
		if(result.hasErrors()) {
			System.out.println("==Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			// 다시 form이 적용되있는 페이지로 감
			return "createoffer";
		}
		offerService.insert(offer);
		//System.out.println(offer);
		
		return "offercreated";
	}*/
}
