/**
 * Sample CRUD repo interface extending the CRUD repo class of Spring.
 * @author constantinn
 * */
package org.java.ws.sample.repository;

import org.java.ws.sample.entity.RandomItem;
import org.springframework.data.repository.CrudRepository;

public interface RandomItemRepository extends CrudRepository<RandomItem,Long> {
	
	RandomItem findRandomItemById (long randomItemId);
	
}
