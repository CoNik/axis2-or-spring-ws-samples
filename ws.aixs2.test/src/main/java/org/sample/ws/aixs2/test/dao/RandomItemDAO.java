package org.sample.ws.aixs2.test.dao;

import org.sample.ws.aixs2.test.entity.RandomItem;

public interface RandomItemDAO {
	
	void addRandomItem (RandomItem r);
	
	RandomItem getRandomItemById (Long id);
	
}
