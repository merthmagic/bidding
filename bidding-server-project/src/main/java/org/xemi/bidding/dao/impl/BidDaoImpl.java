package org.xemi.bidding.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.xemi.bidding.dao.BidDao;
import org.xemi.bidding.entity.Bid;
import org.xemi.bidding.mapper.BidMapper;

@Repository
public class BidDaoImpl implements BidDao{

	@Resource
	private BidMapper bidMapper;
	
	@Override
	public Bid getBidById(Long id) {
		return bidMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addBid(Bid bid) {
		return bidMapper.insert(bid);
	}

	
}
