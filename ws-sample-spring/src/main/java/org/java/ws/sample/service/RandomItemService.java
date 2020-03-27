/**
 * A sample Service class containing the implementation of a service interface.
 * Handles the data calls to the DB.
 * @author constantinn
 * */

package org.java.ws.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.java.ws.sample.entity.RandomItem;
import org.java.ws.sample.repository.RandomItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomItemService implements IRandomItemService{
	
	@Autowired
	RandomItemRepository repository;
	
	@Override
	public RandomItem getRandomItemById(Long id) {
		RandomItem obj = repository.findRandomItemById(id);
		return obj;
	}

	@Override
	public List<RandomItem> getAllRandomItems() {
		List<RandomItem> list = new ArrayList<>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public boolean addRandomItem(RandomItem randomItem) {
		List<RandomItem> list = (List<RandomItem>) repository.findAll() ; 	
        if (list.size() > 0) {
           return false;
        } else {
        	randomItem = repository.save(randomItem);
           return true;
        }
	}
	
}
