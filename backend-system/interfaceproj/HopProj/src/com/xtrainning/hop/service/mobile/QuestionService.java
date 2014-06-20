package com.xtrainning.hop.service.mobile;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.xtrainning.hop.entity.Member;
import com.xtrainning.hop.request.mobile.CreateQuestionRequest;
import com.xtrainning.hop.request.mobile.GetAnswerListRequest;
import com.xtrainning.hop.request.mobile.GetQuestionDetailRequest;
import com.xtrainning.hop.resolver.MemberResolver;
import com.xtrainning.hop.resolver.QuestionResolver;
import com.xtrainning.hop.resolver.TopicResolver;
import com.xtrainning.hop.response.mobile.AnswerListResponse;
import com.xtrainning.hop.response.mobile.AnswerResponse;
import com.xtrainning.hop.response.mobile.QuestionDetailResponse;
import com.xtrainning.hop.response.mobile.SimpleResponse;
import com.xtrainning.hop.response.mobile.TopicResponse;

@ServiceMethodBean
public class QuestionService extends MobileBaseService{
	@Autowired private QuestionResolver questionResolver;
	@Autowired private TopicResolver topicResolver;
	@Autowired private MemberResolver memberResolver;
	
	@ServiceMethod(method = "question.getQuestionDetail",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getQuestionDetail(GetQuestionDetailRequest request) {
		QuestionDetailResponse response = new QuestionDetailResponse();
		List<AnswerResponse> list = new ArrayList<AnswerResponse>();
		AnswerResponse r = new AnswerResponse();
		r.setAnswerId(3L);
		r.setAnswerContent("answer");
		AnswerResponse r1 = new AnswerResponse();
		r1.setAnswerId(4L);
		r1.setAnswerContent("answer2");
		list.add(r);
		list.add(r1);
		response.setAnswerList(list);
		
		List<TopicResponse> list2 = new ArrayList<TopicResponse>();
		TopicResponse r3 = new TopicResponse();
		r3.setFollowedNum(3L);
		r3.setTopicId(1L);
		r3.setTopicName("name");
		TopicResponse r4 = new TopicResponse();
		r4.setTopicId(2L);
		r4.setFollowedNum(6L);
		list2.add(r3);
		list2.add(r4);
		response.setTopicList(list2);
		
		List<String>imageUrlList = new ArrayList<String>();
		imageUrlList.add("url1");
		imageUrlList.add("url2");
		
		response.setImageList(imageUrlList);
        return response;
	}
	
	@ServiceMethod(method = "question.getAnswerList",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getAnswerList(GetAnswerListRequest request) {
		AnswerListResponse response = new AnswerListResponse();
		List<AnswerResponse> list = new ArrayList<AnswerResponse>();
		AnswerResponse r = new AnswerResponse();
		r.setAnswerId(3L);
		r.setAnswerContent("answer");
		AnswerResponse r1 = new AnswerResponse();
		r1.setAnswerId(4L);
		r1.setAnswerContent("answer2");
		list.add(r);
		list.add(r1);
		response.setAnswerList(list);
		return response;
		
	}
	
	@ServiceMethod(method = "question.createQuestion",version = "1.0",needInSession = NeedInSessionType.YES)
    public Object createQuestion(CreateQuestionRequest request) {
		Member m = memberResolver.getMemberById(request.getMemberId());
		if(m == null){
			return new BusinessServiceErrorResponse(
        			request.getRopRequestContext().getMethod(), "NO_SUCH_MEMBER",
        			request.getRopRequestContext().getLocale(), request.getMemberId());
		}
		questionResolver.createQuestion(request, m);
		return new SimpleResponse();
	}
	
}
