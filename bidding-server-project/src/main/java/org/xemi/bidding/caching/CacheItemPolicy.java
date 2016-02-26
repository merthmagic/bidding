package org.xemi.bidding.caching;

import java.sql.Timestamp;

public class CacheItemPolicy {
	private Timestamp absoluteExpiration;
	
	public CacheItemPolicy(long absoluteExpiration){
		this.absoluteExpiration = new Timestamp(absoluteExpiration);
	}

	public Timestamp getAbsoluteExpiration() {
		return absoluteExpiration;
	}

	public void setAbsoluteExpiration(Timestamp absoluteExpiration) {
		this.absoluteExpiration = absoluteExpiration;
	}
}
