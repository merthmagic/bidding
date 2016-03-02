package org.xemi.bidding.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploadController extends BaseController{

	private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@RequestMapping(value="/file/upload",method=RequestMethod.POST)
	public String fileUpload(){
		return "";
	}
	
	
}
