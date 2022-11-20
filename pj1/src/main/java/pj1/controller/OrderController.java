package pj1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import pj1.dto.OrderItemDto;
import pj1.service.MemberService;
import pj1.service.OrderService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	private MemberService memberService;
	
	
	@RequestMapping(value="/insertOrder", method = RequestMethod.POST)
	public int insertOrderInfo(@RequestBody List<OrderItemDto> orderInfo) throws Exception {
		
		OrderItemDto order = orderInfo.get(0);
	
		orderService.insertOrder(order);

		orderService.insertOrderDetail(orderInfo);
	 
		 return 1;
		 
	}
		
		
	

}
