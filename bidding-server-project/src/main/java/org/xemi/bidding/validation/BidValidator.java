package org.xemi.bidding.validation;

import java.math.BigDecimal;

import org.xemi.bidding.models.BidModel;

public class BidValidator {
	
	public static boolean  validateBidModel(BidModel bidModel){
		boolean ret = true;
		if(bidModel.getAmount() == null || bidModel.getAmount().compareTo(BigDecimal.ZERO) < 0)
			return false;
		if(bidModel.getTitle() == null || bidModel.getTitle().isEmpty())
			return false;
		
		return ret;
	}
}
