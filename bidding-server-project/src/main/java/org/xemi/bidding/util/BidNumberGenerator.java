package org.xemi.bidding.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BidNumberGenerator {
	
	public static String generate(){
		StringBuffer buffer = new StringBuffer();
		String serial = new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
		String random = Long.toString(Math.round(Math.random()*89999+10000));
		
		//Check why some bid number is shorter than normal, the following block will be removed
		//after we can ensure it runs fine.
		if(serial.length() != 15)
			throw new IllegalArgumentException("serial length is not correct,serial is " + serial);
		
		if(random.length() != 5)
			throw new IllegalArgumentException("random length is not correct,random is " + random);
		
		buffer.append(serial);
		buffer.append(random);
		return buffer.toString();
	}
	
	public static String generate(String prefix){
		if(prefix == null)
			throw new NullPointerException();
		return prefix+generate();
	}
}
