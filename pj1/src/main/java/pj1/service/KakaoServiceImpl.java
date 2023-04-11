package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import pj1.dto.OrderItemDto;
import pj1.mapper.OrderMapper;
import pj1.vo.ApproveResponse;
import pj1.vo.ReadyResponse;

@Service
public class KakaoServiceImpl implements KakaoPayService {
	
	
	@Autowired
	private OrderMapper orderMapper;
	
	private ReadyResponse readyResponse;
	
	@Override
	public ReadyResponse payReady(List<OrderItemDto> orderInfo) {
		OrderItemDto order = orderInfo.get(0);
		//가격총합구하기
		int totalPrice = 0;
		for(int i=0; i<orderInfo.size(); i++) {
			totalPrice+=orderInfo.get(i).getItemPrice();
		}
		
		//주문명 만들기
		String itemName = orderInfo.get(0).getItemName() +" 그 외" + (orderInfo.size()-1);
		
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.add("cid", "TC0ONETIME");
		parameters.add("partner_order_id", "inflearn");
		parameters.add("partner_user_id", "inflearn");
		parameters.add("item_name", itemName);
		parameters.add("quantity", String.valueOf(order.getItemAmount()));
		parameters.add("total_amount", String.valueOf(totalPrice));
		parameters.add("tax_free_amount", "0");
		parameters.add("approval_url", "http://localhost:8080/order/pay/completed"); // 결제승인시 넘어갈 url
		parameters.add("cancel_url", "http://localhost:8080/order/pay/cancel"); // 결제취소시 넘어갈 url
		parameters.add("fail_url", "http://localhost:8080/order/pay/fail"); // 결제 실패시 넘어갈 url
		
		//파라미터, 헤더
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
		
		//외부에 보낼 url
		RestTemplate template = new RestTemplate();
		String url = "https://kapi.kakao.com/v1/payment/ready";
        // template으로 값을 보내고 받아온 ReadyResponse값 readyResponse에 저장.
		readyResponse = template.postForObject(url, requestEntity, ReadyResponse.class);
        // 받아온 값 return

		return readyResponse;
	}

	@Override
	public ApproveResponse payApprove(String pgToken) {
		
		
		// request값 담기.
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.add("cid", "TC0ONETIME");
		parameters.add("tid", readyResponse.getTid());
		parameters.add("partner_order_id", "inflearn"); // 주문명
		parameters.add("partner_user_id", "inflearn");
		parameters.add("pg_token", pgToken);
		
        // 하나의 map안에 header와 parameter값을 담아줌.
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
		
        // 외부url 통신
		RestTemplate template = new RestTemplate();
		String url = "https://kapi.kakao.com/v1/payment/approve";
        // 보낼 외부 url, 요청 메시지(header,parameter), 처리후 값을 받아올 클래스. 
		ApproveResponse approveResponse = template.postForObject(url, requestEntity, ApproveResponse.class);
		
	 
		
		return approveResponse;
	}
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "KakaoAK 733557b037052fd13bb6e6e30fef105b");
		headers.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		return headers;
	}

}
