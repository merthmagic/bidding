package org.xemi.bidding.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xemi.bidding.dao.BidDao;
import org.xemi.bidding.entity.Bid;
import org.xemi.bidding.models.BidModel;
import org.xemi.bidding.services.BidService;
import org.xemi.bidding.util.BidNumberGenerator;
import org.xemi.bidding.validation.BidValidator;

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
		if(bidModel == null)
			throw new IllegalArgumentException("Argument 'bidModel' should not be null ");
		
		if(!BidValidator.validateBidModel(bidModel)){
			throw new IllegalArgumentException("Argument 'bidModel' does not contain the proper fields");
		}
		
		//TODO: too many conflict in model and entity, plan to re-design the table
		Date now = new Date();
		Bid bid = new Bid();
		bid.setTitle(bidModel.getTitle());
		bid.setBidNumber(BidNumberGenerator.generate());
		bid.setDescription(bidModel.getDescription());
		bid.setAmount(bidModel.getAmount().longValue());//TODO: why generated field is long but not BigDecimal
		bid.setCreatedOn(now);
		bid.setModifedOn(now);
		bid.setSortOrder(0);
		bid.setStatus(0);
		bid.setDraft(new Byte((byte) 0));
		bid.setLocationId(0);
		bid.setOwnerId(0);
		
		return bidDao.addBid(bid);
	}
	
	
}
