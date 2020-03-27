package org.sample.ws.aixs2.test.service;

import javax.transaction.Transactional;

import org.sample.ws.aixs2.test.dao.RandomItemDAO;
import org.sample.ws.aixs2.test.entity.RandomItem;
import org.springframework.stereotype.Service;

@Service
public class RandomItemService implements IRandomItemService{
	
	RandomItemDAO item;
	
	public void setRandomItemDAO(RandomItemDAO item) {
		this.item = item;
	}
	
	@Transactional
	public void addRandomItem(RandomItem r) {
		this.item.addRandomItem(r);
		
	}

	@Transactional
	public RandomItem getRandomItemById(Long id) {
		return this.item.getRandomItemById(id);
	}
	
	
	
}
