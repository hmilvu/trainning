package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;



public class DeleteCommentRequest extends MemberBaseRequest{
	@NotNull
	private Long commentId;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
    
}

