package com.xtrainning.hop.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.entity.MemberWarning;

/**
 	* A data access object (DAO) providing persistence and search support for MemberWarning entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberWarning
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class MemberWarningDAO extends BaseHibernateDAO  {
	    private static final Logger log = LoggerFactory.getLogger(MemberWarningDAO.class);
	

    
    public void save(MemberWarning transientInstance) {
        log.debug("saving MemberWarning instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
//    private static final String CHECK_MEMBER_WARNING = "select count(*) from MemberWarning where question.id = ? and member.id = ? ";
//	public long checkMemberWarning(Long questionId, Long memberId) {
//		@SuppressWarnings("unchecked")
//		List<Long> list = getHibernateTemplate().find(CHECK_MEMBER_WARNING, questionId, memberId); 
//		if(list.size() > 0){
//			return list.get(0);
//		} else {
//			return 0;
//		}
//	}
}