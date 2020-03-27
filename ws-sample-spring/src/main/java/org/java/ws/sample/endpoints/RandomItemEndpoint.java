package org.java.ws.sample.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.java.ws.sample.entity.AddRandomItemRequest;
import org.java.ws.sample.entity.AddRandomItemResponse;
import org.java.ws.sample.entity.GetAllRandomItemsResponse;
import org.java.ws.sample.entity.GetRandomItemByIdRequest;
import org.java.ws.sample.entity.GetRandomItemByIdResponse;
import org.java.ws.sample.entity.RandomItem;
import org.java.ws.sample.entity.RandomItemInfo;
import org.java.ws.sample.entity.ServiceStatus;
import org.java.ws.sample.service.IRandomItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

public class RandomItemEndpoint {

	private static final String NAMESPACE_URI = "http://www.cn.com/article-ws";

	@Autowired
	private IRandomItemService randomItemService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRandomItemById")
	@ResponsePayload
	public GetRandomItemByIdResponse getRandomItem(@RequestPayload GetRandomItemByIdRequest request) {

		GetRandomItemByIdResponse response = new GetRandomItemByIdResponse();
		RandomItemInfo rii = new RandomItemInfo();
		BeanUtils.copyProperties(randomItemService.getRandomItemById(request.getId()), rii);
		response.setRandomItemInfo(rii);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllRandomItems")
	@ResponsePayload
	public GetAllRandomItemsResponse getAllRandomItems() {

		GetAllRandomItemsResponse response = new GetAllRandomItemsResponse();
		List<RandomItemInfo> randomItemInfoList = new ArrayList<>();
		List<RandomItem> randomItemList = randomItemService.getAllRandomItems();
		for (int i = 0; i < randomItemList.size(); i++) {

			RandomItemInfo ob = new RandomItemInfo();
			BeanUtils.copyProperties(randomItemList.get(i), ob);
			randomItemInfoList.add(ob);
		}
		response.getRandomItemInfo().addAll(randomItemInfoList);
		return response;

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addArticleRequest")
	@ResponsePayload
	public AddRandomItemResponse addRandomItem(@RequestPayload AddRandomItemRequest request) {
		AddRandomItemResponse response = new AddRandomItemResponse();

		ServiceStatus serviceStatus = new ServiceStatus();

		RandomItem randomItem = new RandomItem();

		randomItem.setRname(request.getName());
		randomItem.setRtype(request.getType());

		boolean flag = randomItemService.addRandomItem(randomItem);
		
		if (flag == false) {
			serviceStatus.setStatusCode(HttpStatus.CONFLICT.toString());
			serviceStatus.setMessage(" Failed to process the request!");
			response.setServiceStatus(serviceStatus);
		} else {
			RandomItemInfo randomItemInfo = new RandomItemInfo();
			BeanUtils.copyProperties(randomItem, randomItemInfo);
			response.setRandomItemInfo (randomItemInfo);
			serviceStatus.setStatusCode(HttpStatus.OK.toString());
			serviceStatus.setMessage(" Request processed succesfully!");
			response.setServiceStatus(serviceStatus);
		}
		return response;
	}
	
	

}
