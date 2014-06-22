package com.xtrainning.hop.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.entity.MemberFollowTopic;

/**
 	* A data access object (DAO) providing persistence and search support for MemberFollowTopic entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberFollowTopic
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class MemberFollowTopicDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberFollowTopicDAO.class);
	

    
    public void save(MemberFollowTopic transientInstance) {
        log.debug("saving MemberFollowTopic instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

	public Long getFollowTopicFlag(final Long memberId, final Long topicId) {
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery("select count(*) from MemberFollowTopic where member.id = ? and topic.id = ? ");
				q.setLong(0, memberId);
				q.setLong(1, topicId);
				return (Long) q.uniqueResult();
			}
		});
	}

	public void removeFollow(final Long memberId, final Long topicId) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery("delete from MemberFollowTopic where member.id = ? and topic.id = ? ");
				q.setLong(0, memberId);
				q.setLong(1, topicId);
				return q.executeUpdate();
			}
		});
		
	}
}