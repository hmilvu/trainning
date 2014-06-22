package com.xtrainning.hop.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtrainning.hop.dao.QuestionDAO;
import com.xtrainning.hop.dao.TopicDAO;
import com.xtrainning.hop.entity.Question;
import com.xtrainning.hop.entity.Topic;
import com.xtrainning.hop.request.mobile.GetTopicDetailRequest;
import com.xtrainning.hop.request.mobile.GetTopicListRequest;
import com.xtrainning.hop.response.mobile.QuestionResponse;
import com.xtrainning.hop.response.mobile.TopicListResponse;
import com.xtrainning.hop.response.mobile.TopicResponse;
@Service
public class TopicResolver extends BaseResolver{
	@Autowired private TopicDAO topicDao;
	@Autowired private QuestionDAO questionDao;

	public TopicListResponse getTopicListReponse(GetTopicListRequest request) {
		List<Topic> list  = topicDao.getTopicList(request);
		List<TopicResponse> responseList = new ArrayList<TopicResponse>();
		for(Topic t : list){
			List<Question> questionList = questionDao.getByTopicId(t.getId(), 3);
			List<QuestionResponse> qResponseList = new ArrayList<QuestionResponse>();
			for(Question q : questionList){
				QuestionResponse r = q.toResponse();
				qResponseList.add(r);
			}
			TopicResponse topicResponse = t.toResponse();
			responseList.add(topicResponse);
		}
		TopicListResponse response = new TopicListResponse();
		response.setTopicList(responseList);
		return response;
	}

	public TopicResponse getTopicReponse(Topic t, GetTopicDetailRequest request) {
		TopicResponse r = t.toResponse();
		List<Question> questionList = questionDao.getByTopicId(t.getId(), request.getPageNumber(), request.getPageSize());
		List<QuestionResponse> qrList = new ArrayList<QuestionResponse>();
		for(Question q : questionList){
			QuestionResponse qr = q.toResponse();
			qrList.add(qr);
		}
		r.setQuestionList(qrList);
		return null;
	}

	public Topic getById(Long topicId) {
		return topicDao.getById(topicId);
	}



    
    


}
