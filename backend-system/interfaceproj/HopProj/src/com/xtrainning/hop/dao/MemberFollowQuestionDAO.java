package com.xtrainning.hop.dao;

import static org.hibernate.criterion.Example.create;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.entity.MemberFollowQuestion;

/**
 	* A data access object (DAO) providing persistence and search support for MemberFollowQuestion entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberFollowQuestion
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class MemberFollowQuestionDAO extends BaseHibernateDAO  {
	private static final Logger log = LoggerFactory.getLogger(MemberFollowQuestionDAO.class);
    
    public void save(MemberFollowQuestion transientInstance) {
        log.debug("saving MemberFollowQuestion instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

	public void removeFollow(final Long memberId, final Long questionId) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery("delete from MemberFollowQuestion where member.id = ? and question.id = ? ");
				q.setLong(0, memberId);
				q.setLong(1, questionId);
				return q.executeUpdate();
			}
		});
		
	}


//    private static final String CHECK_MEMBER_FOLLOWED_QUESTION = "select count(*) from MemberFollowQuestion where question.id = ? and member.id = ? ";
//	public long checkMemberFollowedQuestion(Long questionId, Long memberId) {
//		@SuppressWarnings("unchecked")
//		List<Long> list = getHibernateTemplate().find(CHECK_MEMBER_FOLLOWED_QUESTION, questionId, memberId); 
//		if(list.size() > 0){
//			return list.get(0);
//		} else {
//			return 0;
//		}
//	}
}