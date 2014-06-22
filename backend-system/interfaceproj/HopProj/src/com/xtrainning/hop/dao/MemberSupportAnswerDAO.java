package com.xtrainning.hop.dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.entity.MemberSupportAnswer;

/**
 	* A data access object (DAO) providing persistence and search support for MemberSupportAnswer entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberSupportAnswer
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class MemberSupportAnswerDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberSupportAnswerDAO.class);
    
    public void save(MemberSupportAnswer transientInstance) {
        log.debug("saving MemberSupportAnswer instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

	public Integer deleteSupport(final Long memberId, final Long answerId) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery("delete from MemberSupportAnswer where member.id = ? and answer.id = ?");
				q.setLong(0, memberId);
				q.setLong(1, answerId);
				return q.executeUpdate();
			}
		});
	}

	public MemberSupportAnswer getSupport(final Long memberId, final Long answerId) {
		return getHibernateTemplate().execute(new HibernateCallback<MemberSupportAnswer>() {
			@Override
			public MemberSupportAnswer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery("from MemberSupportAnswer where member.id = ? and answer.id = ?");
				q.setLong(0, memberId);
				q.setLong(1, answerId);
				q.setMaxResults(1);
				return (MemberSupportAnswer) q.uniqueResult();
			}
		});
	}
}