package com.xtrainning.hop.service.mobile;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.xtrainning.hop.common.Constants;
import com.xtrainning.hop.entity.Topic;
import com.xtrainning.hop.request.mobile.GetNewsListRequest;
import com.xtrainning.hop.request.mobile.GetTopicDetailRequest;
import com.xtrainning.hop.request.mobile.GetTopicListRequest;
import com.xtrainning.hop.resolver.TopicResolver;
import com.xtrainning.hop.response.mobile.QuestionResponse;
import com.xtrainning.hop.response.mobile.TopicListResponse;
import com.xtrainning.hop.response.mobile.TopicResponse;

@ServiceMethodBean
public class TopicService extends MobileBaseService{
	@Autowired private TopicResolver topicResolver;

	@ServiceMethod(method = "topic.getTopicList",version = "1.0",needInSession = NeedInSessionType.YES)
    public Object getTopicList(GetTopicListRequest request) {
		TopicListResponse response = topicResolver.getTopicListReponse(checkPageInfo(request));
        return response;
	}
	
	private GetTopicListRequest checkPageInfo(GetTopicListRequest request){
		if(request.getPageNumber() == null || request.getPageNumber() <= 0){
			request.setPageNumber(1);
		} 
		if(request.getPageSize() == null || request.getPageSize() <= 0 || request.getPageSize() > 100){
			request.setPageSize(Constants.DEFAULT_PAGE_SIZE);
		}
		return request;
	}
	
	@ServiceMethod(method = "topic.getTopicDetail",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getTopicDetail(GetTopicDetailRequest request) {
		Topic t = topicResolver.getById(request.getTopicId());
		if(t == null){
			return new BusinessServiceErrorResponse(
        			request.getRopRequestContext().getMethod(), "NO_SUCH_TOPIC",
        			request.getRopRequestContext().getLocale(), request.getTopicId());
		}
		TopicResponse response = topicResolver.getTopicReponse(t, checkPageInfo(request));
        return response;
	}
	
	private GetTopicDetailRequest checkPageInfo(GetTopicDetailRequest request){
		if(request.getPageNumber() == null || request.getPageNumber() <= 0){
			request.setPageNumber(1);
		} 
		if(request.getPageSize() == null || request.getPageSize() <= 0 || request.getPageSize() > 100){
			request.setPageSize(Constants.DEFAULT_PAGE_SIZE);
		}
		return request;
	}
}
