package com.xtrainning.hop.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.common.Constants.MEMBER_STATUS;
import com.xtrainning.hop.entity.Member;

/**
 	* A data access object (DAO) providing persistence and search support for Member entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.Member
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class MemberDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberDAO.class);
	
    public void save(Member transientInstance) {
        log.debug("saving Member instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    public Member findById(java.lang.Long id) {
        log.debug("getting Member instance with id: " + id);
        try {
            Member instance = (Member) getHibernateTemplate()
                    .get(Member.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public Integer updateLastAccessTime(final Long memberId) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery("update Member set lastAccessTime = ? where id = ?");
				q.setTimestamp(0, new Timestamp(new Date().getTime()));	
				q.setLong(1, memberId);				
				return q.executeUpdate();
			}
		});
	}

	public Long getByPhoneNumber(final String phoneNumber) {
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery("select id from Member where phoneNumber = ?");
				q.setString(0, phoneNumber);	
				q.setMaxResults(1);
				return (Long) q.uniqueResult();
			}
		});
	}

	public Long getByCredentials(final String phoneNumber, final String password) {
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery("select id from Member where phoneNumber = ? and password = ? and status = " + MEMBER_STATUS.ACTIVE.getValue());
				q.setString(0, phoneNumber);	
				q.setString(1, password);
				q.setMaxResults(1);
				return (Long) q.uniqueResult();
			}
		});
	}

	public Long checkMemberByThirdPartyId(final String thirdPartyId, final Integer type) {
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery("select id from Member where thirdPartyId = ? and thirdPartyType = ? and status = " + MEMBER_STATUS.ACTIVE.getValue());
				q.setString(0, thirdPartyId);	
				q.setInteger(1, type);
				q.setMaxResults(1);
				return (Long) q.uniqueResult();
			}
		});
	}

}