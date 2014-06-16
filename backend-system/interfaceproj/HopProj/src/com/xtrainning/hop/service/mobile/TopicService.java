package com.xtrainning.hop.service.mobile;
import java.util.ArrayList;
import java.util.List;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.xtrainning.hop.request.mobile.GetTopicListRequest;
import com.xtrainning.hop.response.mobile.QuestionResponse;
import com.xtrainning.hop.response.mobile.TopicListResponse;
import com.xtrainning.hop.response.mobile.TopicResponse;

@ServiceMethodBean
public class TopicService extends MobileBaseService{
//	@Autowired private MemberResolver memberResolver;

	@ServiceMethod(method = "topic.getTopicList",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getTopicList(GetTopicListRequest request) {
//		Member m = memberResolver.fetchMemberByUUID(request);
//		MemberIdResponse response = new MemberIdResponse();
//		response.setMemberId(m.getId());
		TopicListResponse response = new TopicListResponse();
		List<TopicResponse> list = new ArrayList<TopicResponse>();
		TopicResponse r = new TopicResponse();
		r.setFollowedNum(3L);
		r.setTopicId(1L);
		r.setTopicName("name");
		TopicResponse r1 = new TopicResponse();
		r1.setTopicId(2L);
		r1.setFollowedNum(6L);
		list.add(r);
		list.add(r1);
		response.setTopicList(list);
		
		List<QuestionResponse> list2 = new ArrayList<QuestionResponse>();
		QuestionResponse q1 = new QuestionResponse();
		q1.setQuestionId(3L);
		q1.setQuestionTopic("q1");
		
		QuestionResponse q2 = new QuestionResponse();
		q2.setQuestionId(1L);
		q2.setQuestionTopic("q1");
		list2.add(q1);
		list2.add(q2);
		
		r.setQuestionList(list2);
		r1.setQuestionList(list2);
		
        return response;
	}
	
}
