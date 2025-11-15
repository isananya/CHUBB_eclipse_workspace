package com.chuub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chuub.repository.OrderRepository;
import com.chuub.request.Item;
import com.chuub.request.Order1;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	@Transactional
	public void insertOrder(Order1 order) {
		if (order.getItems() != null) {
            for (Item item : order.getItems()) {
                item.setOrder(order); 
            }
        }
		orderRepository.save(order);
		log.debug(order.toString());
	}
}
