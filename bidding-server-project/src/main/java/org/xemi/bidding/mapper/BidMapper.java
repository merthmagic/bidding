package org.xemi.bidding.mapper;

import org.xemi.bidding.entity.Bid;

public interface BidMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bid record);

    int insertSelective(Bid record);

    Bid selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bid record);

    int updateByPrimaryKeyWithBLOBs(Bid record);

    int updateByPrimaryKey(Bid record);
}