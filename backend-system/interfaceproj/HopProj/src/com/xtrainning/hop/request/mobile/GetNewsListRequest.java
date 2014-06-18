package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;



public class GetNewsListRequest extends MemberBaseRequest{
    @NotNull
	private Integer pageSize;
    @NotNull
	private Integer pageNumber;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
    
}

