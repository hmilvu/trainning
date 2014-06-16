package com.xtrainning.hop.request.mobile;

import com.sun.istack.internal.NotNull;

public class GetNewsListRequest extends MobileBaseRequest{
    @NotNull
    private Long memberId;
    @NotNull
	private Integer pageSize;
    @NotNull
	private Integer pageNumber;
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
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

