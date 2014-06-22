package com.xtrainning.hop.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.entity.Question;
import com.xtrainning.hop.response.mobile.QuestionDetailResponse;
import com.xtrainning.hop.utils.DateUtils;

/**
 	* A data access object (DAO) providing persistence and search support for Question entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.Question
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class QuestionDAO extends BaseHibernateDAO  {
	private static final Logger log = LoggerFactory.getLogger(QuestionDAO.class);
	

    
    public void save(Question transientInstance) {
        log.debug("saving Question instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    private final static String GET_QUESTION_DETAIL_RESPONSE = "select m.id, " +
    		"m.nick_name, " +
    		"q.description, " +
    		"q.follow_num, " +
    		"q.comment_count, " +
    		"q.create_time " +
    		"from question q, member m where q.member_id = m.id and q.id = ? ";
	public QuestionDetailResponse getQuestionDetailResponse(final Long questionId) {
		return getHibernateTemplate().execute(new HibernateCallback<QuestionDetailResponse>() {
			@SuppressWarnings("rawtypes")
			@Override
			public QuestionDetailResponse doInHibernate(Session session) throws HibernateException,
					SQLException {
				SQLQuery query = session.createSQLQuery(GET_QUESTION_DETAIL_RESPONSE);
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		        query.setLong(0, questionId);  
		        Map map = (Map) query.uniqueResult();
		        QuestionDetailResponse response = new QuestionDetailResponse();
		        response.setMemberId(((BigInteger) map.get("id")).longValue());
		        response.setNickName((String) map.get("nick_name"));
		        response.setDescription((String)map.get("description"));
		        response.setFollowedNum((Integer) map.get("follow_num"));
		        response.setCommentNum((Integer)map.get("comment_count"));
		        response.setCreateTime(DateUtils.dateToyyyyMMddHHmi((Timestamp)(map.get("create_time"))));
		        return response;
			}
		});
	}
	
	private final static String GET_MEMBER_QUESTION_DETAIL_RESPONSE = "select m.id, " +
    		"m.nick_name, " +
    		"q.description, " +
    		"q.follow_num, " +
    		"q.comment_count, " +
    		"q.create_time, " +
    		"(select count(*) from member_follow_question mf where mf.member_id = :memberId and mf.question_id = :questionId)as mfq_count, " +
    		"(select count(*) from member_warning mw where mw.member_id = :memberId and mw.question_id =  :questionId)mw_count " +
    		"from question q, member m where q.member_id = m.id and q.id = :questionId ";
	
	public QuestionDetailResponse getQuestionDetailResponse(final Long questionId,
			final Long memberId) {
		return getHibernateTemplate().execute(new HibernateCallback<QuestionDetailResponse>() {
			@SuppressWarnings("rawtypes")
			@Override
			public QuestionDetailResponse doInHibernate(Session session) throws HibernateException,
					SQLException {
				SQLQuery query = session.createSQLQuery(GET_MEMBER_QUESTION_DETAIL_RESPONSE);
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		        query.setLong("questionId", questionId);  
		        query.setLong("memberId", memberId);  
		        Map map = (Map) query.uniqueResult();
		        QuestionDetailResponse response = new QuestionDetailResponse();
		        response.setMemberId(((BigInteger) map.get("id")).longValue());
		        response.setNickName((String) map.get("nick_name"));
		        response.setDescription((String)map.get("description"));
		        response.setFollowedNum((Integer) map.get("follow_num"));
		        response.setCommentNum((Integer)map.get("comment_count"));
		        response.setCreateTime(DateUtils.dateToyyyyMMddHHmi((Timestamp)(map.get("create_time"))));
		        BigInteger memberFollowedNum = (BigInteger)map.get("mfq_count");
		        if(memberFollowedNum.intValue() > 0){
		        	response.setFollowedFlag(1);
		        }
		        BigInteger memberWarningNum = (BigInteger)map.get("mw_count");
		        if(memberWarningNum.intValue() > 0){
		        	response.setWarningFlag(1);
		        }
		        return response;
			}
		});
	}

	public Question getById(Long questionId) {
		return getHibernateTemplate().get(Question.class, questionId);
	}

    private static final String GET_TOPIC_QUESTION = "select q.* from Question q left outer join QuestionTopic qt " +
    		"on qt.question.id = q.id " +
    		"where q.question = ? and qt.topic.id = ? " +
    		"order by q.followNum desc, q.createTime desc";
	@SuppressWarnings("unchecked")
	public List<Question> getByTopicId(final Long topicId, final int maxNum) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<Question>>() {
			@Override
			public List<Question> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery(GET_TOPIC_QUESTION);
				q.setMaxResults(maxNum);
				return q.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<Question> getByTopicId(final Long topicId, final Integer pageNumber,
			final Integer pageSize) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<Question>>() {
			@Override
			public List<Question> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery(GET_TOPIC_QUESTION);
				q.setFirstResult((pageNumber-1) * pageSize);
				q.setMaxResults(pageSize);
				return q.list();
			}
		});
	}


}