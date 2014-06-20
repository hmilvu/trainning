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
import com.xtrainning.hop.entity.News;
import com.xtrainning.hop.request.mobile.GetNewsListRequest;

/**
 	* A data access object (DAO) providing persistence and search support for News entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.News
  * @author MyEclipse Persistence Tools 
 */

@Repository
public class NewsDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(NewsDAO.class);
	

    
    public void save(News transientInstance) {
        log.debug("saving News instance");
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
	public List<News> getNews(final GetNewsListRequest request) {
		return getHibernateTemplate().executeFind(new HibernateCallback<List<News>>() {
			@Override
			public List<News> doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria cr = session.createCriteria(News.class);
				cr.add(Restrictions.ne("status", NEWS_STATUS.DELETED.getValue()));
				cr.setFirstResult((request.getPageNumber()-1) * request.getPageSize());
				cr.setMaxResults(request.getPageSize());
				cr.addOrder(Order.desc("createTime"));
				return cr.list();
			}
		});
	}
}