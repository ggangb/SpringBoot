package pj1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pj1.dto.CartListDto;
import pj1.service.OrderService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value="/insertOrder", method = RequestMethod.POST)
	public void insertOrder(@RequestBody List<CartListDto> orderList ) throws Exception {
	
		System.out.println(">>>>>>>>>>>>>>>>>>>>>");

		System.out.println(orderList);

		 orderService.insertOrder(orderList);
		 
	}
		
		
	

}
