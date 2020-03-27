/**
 * @author constantinn
 * Interface associated to the RandomItem service class.
 * */

package org.java.ws.sample.service;

import java.util.List;

import org.java.ws.sample.entity.RandomItem;

public interface IRandomItemService {

	RandomItem getRandomItemById(Long id);

	List<RandomItem> getAllRandomItems();

	boolean addRandomItem(RandomItem randomItem);

}
