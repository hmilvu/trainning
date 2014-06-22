package com.xtrainning.hop.service.mobile;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rop.annotation.HttpAction;
import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.xtrainning.hop.common.Constants;
import com.xtrainning.hop.entity.Comment;
import com.xtrainning.hop.entity.Member;
import com.xtrainning.hop.entity.Question;
import com.xtrainning.hop.entity.SysSession;
import com.xtrainning.hop.request.mobile.CreateAnswerRequest;
import com.xtrainning.hop.request.mobile.CreateCommentRequest;
import com.xtrainning.hop.request.mobile.CreateQuestionRequest;
import com.xtrainning.hop.request.mobile.DeleteCommentRequest;
import com.xtrainning.hop.request.mobile.GetAnswerListRequest;
import com.xtrainning.hop.request.mobile.GetCommentListRequest;
import com.xtrainning.hop.request.mobile.GetQuestionDetailRequest;
import com.xtrainning.hop.resolver.MemberResolver;
import com.xtrainning.hop.resolver.QuestionResolver;
import com.xtrainning.hop.resolver.SysSessionResolver;
import com.xtrainning.hop.resolver.TopicResolver;
import com.xtrainning.hop.response.mobile.AnswerListResponse;
import com.xtrainning.hop.response.mobile.CommentListResponse;
import com.xtrainning.hop.response.mobile.QuestionDetailResponse;
import com.xtrainning.hop.response.mobile.SimpleResponse;

@ServiceMethodBean
public class QuestionService extends MobileBaseService{
	@Autowired private QuestionResolver questionResolver;
	@Autowired private TopicResolver topicResolver;
	@Autowired private MemberResolver memberResolver;
	@Autowired private SysSessionResolver sessionResolver;
	@ServiceMethod(method = "question.getQuestionDetail",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getQuestionDetail(GetQuestionDetailRequest request) {
		QuestionDetailResponse response = null;
		if(request.getRopRequestContext().getSessionId() == null){
			response = questionResolver.getQuestionDetailResponseById(request.getQuestionId());
		} else {
			SysSession session = sessionResolver.getValidSessionBySessionId(request.getRopRequestContext().getSessionId());
			if(session.getMember().getId().longValue() == request.getMemberId()){
				response = questionResolver.getQuestionDetailResponseById(request.getQuestionId(), request.getMemberId());
			} else{
				response = questionResolver.getQuestionDetailResponseById(request.getQuestionId());
			}
		}
		AnswerListResponse answerList = questionResolver.getAnswerListResponse(request.getQuestionId(), 1, 10);
		response.setAnswerList(answerList.getAnswerList());
		
		List<String>imageUrlList = new ArrayList<String>();
		imageUrlList.add("url1");
		imageUrlList.add("url2");
		
		response.setImageList(imageUrlList);
        return response;
	}
	
	@ServiceMethod(method = "question.getAnswerList",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getAnswerList(GetAnswerListRequest request) {
		request = checkPageInfo(request);
		AnswerListResponse response = questionResolver.getAnswerListResponse(request.getQuestionId(), request.getPageNumber(), request.getPageSize());
		return response;
	}
	
	private GetAnswerListRequest checkPageInfo(GetAnswerListRequest request){
		if(request.getPageNumber() == null || request.getPageNumber() <= 0){
			request.setPageNumber(1);
		} 
		if(request.getPageSize() == null || request.getPageSize() <= 0 || request.getPageSize() > 100){
			request.setPageSize(Constants.DEFAULT_PAGE_SIZE);
		}
		return request;
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
	
	@ServiceMethod(method = "question.createAnswer",version = "1.0",needInSession = NeedInSessionType.YES)
    public Object createAnswer(CreateAnswerRequest request) {
		Member m = memberResolver.getMemberById(request.getMemberId());
		if(m == null){
			return new BusinessServiceErrorResponse(
        			request.getRopRequestContext().getMethod(), "NO_SUCH_MEMBER",
        			request.getRopRequestContext().getLocale(), request.getMemberId());
		}
		Question q = questionResolver.getQuestionById(request.getQuestionId());
		if(q == null){
			return new BusinessServiceErrorResponse(
        			request.getRopRequestContext().getMethod(), "NO_SUCH_QUESTION",
        			request.getRopRequestContext().getLocale(), request.getQuestionId());
		}
		questionResolver.createAnswer(q, m, request.getContent());
		return new SimpleResponse();
	}
	
	@ServiceMethod(method = "question.getCommentList",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getCommentList(GetCommentListRequest request) {
		CommentListResponse r = questionResolver.getCommentListResponse(request);
		return r;
	}
	
	@ServiceMethod(method = "question.deleteCommentList",version = "1.0",needInSession = NeedInSessionType.YES, httpAction=HttpAction.POST)
    public Object getCommentList(DeleteCommentRequest request) {
		SysSession session = sessionResolver.getValidSessionBySessionId(request.getRopRequestContext().getSessionId());
		if(session.getMember().getId().longValue() != request.getMemberId()){
			SimpleResponse response = new SimpleResponse();
			response.setFlag(1);
			response.setMsg("The memberId in request is not matched with the memberId in session.");
			return response;
		}
		Comment c = questionResolver.getCommentById(request.getCommentId());
		if(c.getMember().getId().longValue() != request.getMemberId()){
			SimpleResponse response = new SimpleResponse();
			response.setFlag(2);
			response.setMsg("The comment is not created by the member. Can not delete.");
			return response;
		}
		questionResolver.deleteComment(c);
		return new SimpleResponse();
	}
	
	@ServiceMethod(method = "question.createComment",version = "1.0",needInSession = NeedInSessionType.YES, httpAction=HttpAction.POST)
    public Object createComment(CreateCommentRequest request) {
		questionResolver.createComment(request);
		return new SimpleResponse();
	}
}
