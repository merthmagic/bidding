package org.xemi.bidding.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xemi.bidding.dao.BidDao;
import org.xemi.bidding.entity.Bid;
import org.xemi.bidding.models.BidModel;
import org.xemi.bidding.services.BidService;

@Service
public class BidServiceImpl implements BidService{

	@Autowired
	private BidDao bidDao;
	
	@Override
	public BidModel getBidModelById(Long id) {
		
		BidModel bidModel = new BidModel();
		
		Bid bid = bidDao.getBidById(id);
		if(bid == null)
			return null;
		
		bidModel.setId(bid.getId());
		bidModel.setBidNumber(bid.getBidNumber());
		bidModel.setStatus(0);
		bidModel.setTitle(bid.getTitle());
		bidModel.setDescription(bid.getDescription());
		return bidModel;
	}

	@Override
	public int addBid(BidModel bidModel) {
		Bid bid = new Bid();
		
		
		return bidDao.addBid(bid);
	}
	
	
}
