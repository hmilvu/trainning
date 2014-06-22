package com.xtrainning.hop.response.mobile;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "commentListResponse")
public class CommentListResponse extends MobileBaseResponse {
	@XmlElement
	private List<CommentResponse> commentList;

	public List<CommentResponse> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentResponse> commentList) {
		this.commentList = commentList;
	}


	
}
