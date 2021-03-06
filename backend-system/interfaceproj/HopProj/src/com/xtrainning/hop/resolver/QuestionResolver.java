package com.xtrainning.hop.resolver;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xtrainning.hop.common.Constants.NEWS_ACTION_TYPE;
import com.xtrainning.hop.common.Constants.NEWS_STATUS;
import com.xtrainning.hop.common.Constants.QUESTION_STATUS;
import com.xtrainning.hop.common.Constants.TOPIC_STATUS;
import com.xtrainning.hop.dao.AnswerDAO;
import com.xtrainning.hop.dao.CommentDAO;
import com.xtrainning.hop.dao.MemberFollowQuestionDAO;
import com.xtrainning.hop.dao.MemberWarningDAO;
import com.xtrainning.hop.dao.NewsDAO;
import com.xtrainning.hop.dao.QuestionDAO;
import com.xtrainning.hop.dao.QuestionTopicDAO;
import com.xtrainning.hop.dao.TopicDAO;
import com.xtrainning.hop.entity.Answer;
import com.xtrainning.hop.entity.Comment;
import com.xtrainning.hop.entity.Member;
import com.xtrainning.hop.entity.MemberFollowQuestion;
import com.xtrainning.hop.entity.News;
import com.xtrainning.hop.entity.Question;
import com.xtrainning.hop.entity.QuestionTopic;
import com.xtrainning.hop.entity.Topic;
import com.xtrainning.hop.request.mobile.CreateCommentRequest;
import com.xtrainning.hop.request.mobile.CreateQuestionRequest;
import com.xtrainning.hop.request.mobile.GetCommentListRequest;
import com.xtrainning.hop.response.mobile.AnswerListResponse;
import com.xtrainning.hop.response.mobile.AnswerResponse;
import com.xtrainning.hop.response.mobile.CommentListResponse;
import com.xtrainning.hop.response.mobile.CommentResponse;
import com.xtrainning.hop.response.mobile.QuestionDetailResponse;
@Service
public class QuestionResolver extends BaseResolver{
	@Autowired private QuestionDAO questionDao;
	@Autowired private TopicDAO topicDao;
	@Autowired private QuestionTopicDAO questionTopicDao;
	@Autowired private MemberFollowQuestionDAO mfqDao;
	@Autowired private NewsDAO newsDao;
	@Autowired private MemberWarningDAO warninDao;
	@Autowired private AnswerDAO answerDao;
	@Autowired private CommentDAO commentDao;
	public void createQuestion(CreateQuestionRequest request, Member member) {
		Question q = new Question();
		q.setName(request.getName());
		q.setDescription(request.getDescription());
		q.setStatus(QUESTION_STATUS.ACTIVE.getValue());
		q.setCreateTime(new Timestamp(new Date().getTime()));
		q.setCommentCount(0);
		q.setFollowNum(0);
		q.setMember(member);
		questionDao.save(q);
		
		MemberFollowQuestion mfq = new MemberFollowQuestion();
		mfq.setMember(member);
		mfq.setQuestion(q);
		mfqDao.save(mfq);
		
		if(StringUtils.isNotBlank(request.getTopicIds())){
			String[]idArray = StringUtils.split(request.getTopicIds(), ",");
			List<Long>idList = new ArrayList<Long>();
			for(String id : idArray){
				idList.add(Long.valueOf(id));
			}
			List<Long> topicIdList = topicDao.filterIds(idList);
			for(Long topicId : topicIdList){
				QuestionTopic qt = new QuestionTopic();
				qt.setQuestion(q);
				Topic t = new Topic();
				t.setId(topicId);
				qt.setTopic(t);
				questionTopicDao.save(qt);
			}
		}
		if(StringUtils.isNotBlank(request.getNewTopicName())){
			Topic t = new Topic();
			t.setName(request.getNewTopicName());
			t.setMember(member);
			t.setCreateTime(new Timestamp(new Date().getTime()));
			t.setFollowNum(0);
			t.setStatus(TOPIC_STATUS.ACTIVE.getValue());
			topicDao.save(t);
		}
		
		News news = new News();
		news.setActionType(NEWS_ACTION_TYPE.QUESTION.getValue());
		news.setCreateTime(q.getCreateTime());
		news.setMember(member);
		news.setMemberIntroduction(member.getIntroduction());
		news.setMemberNickname(member.getNickName());
		news.setStatus(NEWS_STATUS.ACTIVE.getValue());
		news.setSupportNum(0);
		news.setQuestion(q);
		news.setQuestionName(q.getName());
		newsDao.save(news);
	}

	public QuestionDetailResponse getQuestionDetailResponseById(Long questionId, Long memberId) {
		QuestionDetailResponse response = questionDao.getQuestionDetailResponse(questionId, memberId);
		return response;
	}

	@Cacheable(value="QuestionResolver.getQuestionDetailResponseById")
	public QuestionDetailResponse getQuestionDetailResponseById(Long questionId) {
		QuestionDetailResponse response = questionDao.getQuestionDetailResponse(questionId);
		return response;
	}
	
	@Cacheable(value="QuestionResolver.getAnswerListResponse")
	public AnswerListResponse getAnswerListResponse(Long questionId, Integer pageNumber, Integer pageSize) {
		List<Answer> list = answerDao.getByQuestionId(questionId, pageNumber, pageSize);
		List<AnswerResponse> answerList = new ArrayList<AnswerResponse>();
		for(Answer a : list){
			AnswerResponse answerResponse = a.toResponse();
			answerList.add(answerResponse);
		}
		AnswerListResponse response = new AnswerListResponse();
		response.setAnswerList(answerList);
		return response;
	}

	public void createAnswer(Question q, Member m, String content) {
		Answer a = new Answer();
		a.setQuestion(q);
		a.setMember(m);
		a.setContent(content);
		a.setCreateTime(new Timestamp(new Date().getTime()));
		a.setUpdateTime(a.getCreateTime());
		answerDao.save(a);
		
		News news = new News();
		news.setActionType(NEWS_ACTION_TYPE.ANSWER.getValue());
		news.setCreateTime(q.getCreateTime());
		news.setMember(m);
		news.setMemberIntroduction(m.getIntroduction());
		news.setMemberNickname(m.getNickName());
		news.setStatus(NEWS_STATUS.ACTIVE.getValue());
		news.setSupportNum(0);
		news.setQuestion(q);
		news.setQuestionName(q.getName());
		news.setAnswer(a);
		news.setAnswerContent(content);
		newsDao.save(news);
	}

	public Question getQuestionById(Long questionId) {
		return questionDao.getById(questionId);
	}

	public CommentListResponse getCommentListResponse(GetCommentListRequest request) {
		List<Comment> list = commentDao.getByQuestionId(request);
		List<CommentResponse> rList = new ArrayList<CommentResponse>();
		for(Comment c : list){
			CommentResponse r = c.toResponse();
			rList.add(r);
		}
		CommentListResponse response = new CommentListResponse();
		response.setCommentList(rList);
		return response;
	}

	public Comment getCommentById(Long commentId) {
		return commentDao.getById(commentId);
	}

	public void deleteComment(Comment c) {
		commentDao.delete(c);
		
	}

	public void createComment(CreateCommentRequest request) {
		Member m = new Member();
		m.setId(request.getMemberId());
		
		Question q = new Question();
		q.setId(request.getQuestionId());
		
		Comment c = new Comment();
		c.setCreateTime(new Timestamp(new Date().getTime()));
		c.setUpdateTime(c.getCreateTime());
		c.setContent(request.getContent());
		c.setMember(m);
		c.setQuestion(q);
		commentDao.save(c);
		
	}

}
