package org.xemi.bidding.models;

import java.math.BigDecimal;
import java.util.Date;

public class BidModel {
	private Long id;
	
	private String bidNumber;
	
	private String title;
	
	private String description;
	
	private Integer status;
	
	private Date createdOn;
	
	private boolean isDraft;
	
	private Date modifiedOn;
	
	private Date publishedOn;
	
	private BigDecimal amount;
	
	private UserSummaryModel userSummary;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBidNumber() {
		return bidNumber;
	}

	public void setBidNumber(String bidNumber) {
		this.bidNumber = bidNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isDraft() {
		return isDraft;
	}

	public void setDraft(boolean isDraft) {
		this.isDraft = isDraft;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Date getPublishedOn() {
		return publishedOn;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

	public UserSummaryModel getUserSummary() {
		return userSummary;
	}

	public void setUserSummary(UserSummaryModel userSummary) {
		this.userSummary = userSummary;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
