package org.sample.ws.aixs2.test.service;

import org.sample.ws.aixs2.test.entity.RandomItem;

public interface IRandomItemService {
	
	void addRandomItem (RandomItem r);
	
	RandomItem getRandomItemById (Long id);
	
}
