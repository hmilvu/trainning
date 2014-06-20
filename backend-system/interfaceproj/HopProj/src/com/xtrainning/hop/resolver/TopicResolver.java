package com.xtrainning.hop.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtrainning.hop.dao.TopicDAO;
import com.xtrainning.hop.request.mobile.CreateQuestionRequest;
@Service
public class TopicResolver extends BaseResolver{
	@Autowired private TopicDAO topicDao;



    
    


}
