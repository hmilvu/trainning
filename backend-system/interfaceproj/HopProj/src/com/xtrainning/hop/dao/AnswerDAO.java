package com.xtrainning.hop.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.common.Constants.NEWS_STATUS;
import com.xtrainning.hop.entity.Answer;
import com.xtrainning.hop.entity.News;
import com.xtrainning.hop.request.mobile.GetAnswerListRequest;

/**
 	* A data access object (DAO) providing persistence and search support for Answer entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.Answer
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class AnswerDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AnswerDAO.class);
	

    
    public void save(Answer transientInstance) {
        log.debug("saving Answer instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

	@SuppressWarnings("unchecked")
	public List<Answer> getByQuestionId(final Long questionId, final Integer pageNumber, final Integer pageSize) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<Answer>>() {
			@Override
			public List<Answer> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria cr = session.createCriteria(Answer.class);
				cr.createAlias("member", "m");
				cr.add(Restrictions.eq("question.id", questionId));
				cr.setFirstResult((pageNumber-1) * pageSize);
				cr.setMaxResults(pageSize);
				cr.addOrder(Order.desc("createTime"));
				return cr.list();
			}
		});
	}
}