package com.xtrainning.hop.service.mobile;
import java.util.ArrayList;
import java.util.List;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.xtrainning.hop.request.mobile.GetQuestionDetailRequest;
import com.xtrainning.hop.response.mobile.AnswerResponse;
import com.xtrainning.hop.response.mobile.QuestionDetailResponse;
import com.xtrainning.hop.response.mobile.TopicResponse;

@ServiceMethodBean
public class QuestionService extends MobileBaseService{
//	@Autowired private MemberResolver memberResolver;

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
	
}
