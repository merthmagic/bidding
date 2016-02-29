package org.xemi.bidding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xemi.bidding.models.BidModel;
import org.xemi.bidding.services.BidService;

@RestController
public class BidController extends BaseController{

	@Autowired
	private BidService bidService;
	
	@RequestMapping(value="/bids/{id}",method=RequestMethod.GET)
	public BidModel getBidModelById(@PathVariable Long id){
		BidModel bidModel = bidService.getBidModelById(id);
		if(bidModel == null)
			response.setStatus(404);
		return bidModel;
	}
	
	@RequestMapping(value="/bids",method=RequestMethod.POST)
	public void addBid(@RequestBody BidModel bidModel){
		try{
			bidService.addBid(bidModel);
		}
		catch(Exception e){
			e.printStackTrace();
			response.setStatus(500);;
		}
	}
	
	@RequestMapping(value="/bids/detail/{id}",method=RequestMethod.GET)
	public BidModel getBidDetail(@PathVariable Long id){
		BidModel bidModel = bidService.getBidModelById(id);
		if(bidModel == null)
			response.setStatus(404);
		return bidModel;
	}
}
