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

import com.xtrainning.hop.common.Constants.MEMBER_STATUS;
import com.xtrainning.hop.entity.Comment;
import com.xtrainning.hop.request.mobile.GetCommentListRequest;

@Repository
public class CommentDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CommentDAO.class);
	
    public void save(Comment transientInstance) {
        log.debug("saving Comment instance");
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
	public List<Comment> getByQuestionId(final GetCommentListRequest request) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<Comment>>() {
			@Override
			public List<Comment> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria cr = session.createCriteria(Comment.class);
				cr.createAlias("member", "m");
				cr.add(Restrictions.ne("m.status", MEMBER_STATUS.DELETED.getValue()));
				cr.add(Restrictions.eq("question.id", request.getQuestionId()));
				cr.setFirstResult((request.getPageNumber()-1) * request.getPageSize());
				cr.setMaxResults(request.getPageSize());
				cr.addOrder(Order.desc("createTime"));
				return cr.list();
			}
		});
	}

	public Comment getById(Long commentId) {
		return getHibernateTemplate().get(Comment.class, commentId);
	}

	public void delete(Comment c) {
		getHibernateTemplate().delete(c);
	}
}