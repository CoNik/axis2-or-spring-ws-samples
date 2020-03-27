package org.sample.ws.aixs2.test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sample.ws.aixs2.test.entity.RandomItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RandomItemDAOImpl implements RandomItemDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(RandomItemDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public void addRandomItem(RandomItem r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(r);
		logger.info("Person saved successfully, Person Details="+r.toString());
		
	}

	@SuppressWarnings("deprecation")
	public RandomItem getRandomItemById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		RandomItem p = (RandomItem) session.load(RandomItem.class, new Long(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

}
