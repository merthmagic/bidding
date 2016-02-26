package org.xemi.bidding.caching;

public class MemoryCache {
	
	private static Object initLockObject = new Object();
	
	private static MemoryCache defaultCache;
	
	private String name;
	
	public static MemoryCache current(){
		
		if(defaultCache == null){
			synchronized(initLockObject){
				if(defaultCache == null)
					defaultCache = new MemoryCache();
			}
		}
		return defaultCache;
	}
	
	private MemoryCache(){
		
	}
	
	public MemoryCache(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
