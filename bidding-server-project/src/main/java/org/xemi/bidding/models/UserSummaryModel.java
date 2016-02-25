package org.xemi.bidding.models;

public class UserSummaryModel {
	private Long userId;
	
	private String userNickName;

	public UserSummaryModel(){
		
	}
	
	public UserSummaryModel(Long userId,String userNickName){
		this.userId = userId;
		this.userNickName = userNickName;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
}
