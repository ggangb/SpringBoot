package pj1.controller;


import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import pj1.dto.OrderItemDto;
import pj1.service.CartService;
import pj1.service.KakaoPayService;
import pj1.service.OrderService;
import pj1.vo.ApproveResponse;
import pj1.vo.ReadyResponse;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	@Autowired
	private KakaoPayService kakaoService;
	
	
	private List<OrderItemDto> orderdata;
	
	@RequestMapping(value="/order/insert", method = RequestMethod.POST)
	public int insertOrderInfo(@RequestBody List<OrderItemDto> orderInfo) throws Exception {
		
		
		OrderItemDto order = orderInfo.get(0);
		
		orderService.insertOrder(order);
		System.out.println(order);
		
		System.out.println(orderInfo);
		orderService.insertOrderDetail(orderInfo);
		
		List<Integer> cartIdx = new ArrayList<Integer>();

		System.out.println(">>>>>>>>>>>>>>>>>>>>>");

		for (int i = 0; i < orderInfo.size(); i++) {
			cartIdx.add(orderInfo.get(i).getCartIdx());
		}
		
		System.out.println(cartIdx);

		int success = cartService.deleteCartList(cartIdx);
	 
		 return success;
		
	
		 
	}
	
	
	@RequestMapping(value="/order/pay", method = RequestMethod.POST)
	public ReadyResponse payReady(@RequestBody List<OrderItemDto> orderInfo, Model model ) throws Exception {
		System.out.println(orderInfo);
		orderdata = new ArrayList<>(orderInfo);
		System.out.println(orderdata);
		OrderItemDto order = orderInfo.get(0);
		ReadyResponse readyResponse = kakaoService.payReady(orderInfo);
		model.addAttribute("tid", readyResponse.getTid());
		model.addAttribute("order",order);
		return readyResponse;
	}
	
	@GetMapping("/order/pay/completed")
	public void payCompleted(@RequestParam("pg_token") String pgToken, HttpServletResponse response) throws Exception {
		
		
		ApproveResponse approveResponse = kakaoService.payApprove(pgToken);
		
		OrderItemDto order = orderdata.get(0);
		
		orderService.insertOrder(order);
		System.out.println(order);
		
		System.out.println(orderdata);
		orderService.insertOrderDetail(orderdata);
		
		List<Integer> cartIdx = new ArrayList<Integer>();

		System.out.println(">>>>>>>>>>>>>>>>>>>>>");

		for (int i = 0; i < orderdata.size(); i++) {
			cartIdx.add(orderdata.get(i).getCartIdx());
		}
		
		System.out.println(cartIdx);

		cartService.deleteCartList(cartIdx);
		
		String redirect_uri = "http://localhost:3000/mypage/myorderlist";
		response.sendRedirect(redirect_uri);
		
	}
	
//	@GetMapping(value = {"/order/pay/cancel","/order/pay/fail"})
//	public ResponseEntity<?> redirect() {
//		 HttpHeaders headers = new HttpHeaders();
//	        headers.setLocation(URI.create("/"));
//	        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
//	}
	
	
	
//	@RequestMapping(value="/order/pay/completed", method = RequestMethod.GET)
//	public @ResponseBody ReadyResponse payReady(@RequestBody List<OrderItemDto> orderInfo) throws Exception {
//		ReadyResponse readyResponse = kakaoService.payReady(orderInfo);
//		
//		return readyResponse;
//	}
	
		
		
	

}
