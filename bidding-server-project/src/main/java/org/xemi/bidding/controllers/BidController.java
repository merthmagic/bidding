package org.xemi.bidding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xemi.bidding.models.BidModel;
import org.xemi.bidding.services.BidService;

@RestController
public class BidController extends BaseController{

	@Autowired
	private BidService bidService;
	
	@RequestMapping(value="/bid/{id}",method=RequestMethod.GET)
	public BidModel getBidModelById(@PathVariable Long id){
		BidModel bidModel = bidService.getBidModelById(id);
		if(bidModel == null)
			response.setStatus(404);
		return bidModel;
	}
}
