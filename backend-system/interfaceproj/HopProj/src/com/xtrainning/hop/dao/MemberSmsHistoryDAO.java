package com.xtrainning.hop.dao;

import java.sql.SQLException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.common.Constants.SMS_STATUS;
import com.xtrainning.hop.common.Constants.SMS_TYPE;
import com.xtrainning.hop.entity.MemberSmsHistory;

/**
 	* A data access object (DAO) providing persistence and search support for MemberSmsHistory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberSmsHistory
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class MemberSmsHistoryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberSmsHistoryDAO.class);
	
    public void save(MemberSmsHistory transientInstance) {
        log.debug("saving MemberSmsHistory instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

	public MemberSmsHistory getLastestHistory(final SMS_TYPE type,
			final String phoneNumber) {
		return getHibernateTemplate().execute(new HibernateCallback<MemberSmsHistory>() {
			@Override
			public MemberSmsHistory doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery("from MemberSmsHistory where type = ? and phoneNumber = ? and status =" + SMS_STATUS.SENT_SUCCESS.getValue() 
						+ " order by createTime desc");
				q.setInteger(0, type.getValue());
				q.setString(1, phoneNumber);
				q.setMaxResults(1);
				return (MemberSmsHistory) q.uniqueResult();
			}
		});
	}

	public Long getTodayMaxSms(final SMS_TYPE type, final String phoneNumber) {
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery("select count(*) from MemberSmsHistory where status = ? and phoneNumber = ? and type = ? and createTime >= ?");
				q.setInteger(0, SMS_STATUS.SENT_SUCCESS.getValue());
				q.setString(1, phoneNumber);
				q.setInteger(2, type.getValue());
				q.setDate(3, new Date());
				return (Long) q.uniqueResult();
			}
		});
	}

	public void update(MemberSmsHistory msg) {
		log.debug("update MemberSmsHistory instance");
        try {
            getHibernateTemplate().update(msg);
            getHibernateTemplate().flush();
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
		
	}
}