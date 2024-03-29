package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import pj1.dto.OrderItemDto;
import pj1.mapper.OrderMapper;
import pj1.vo.ApproveResponse;
import pj1.vo.ReadyResponse;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public int insertOrder(OrderItemDto orderInfo) throws Exception {
		
		return orderMapper.insertOrder(orderInfo);
	}

	@Override
	public int insertOrderDetail(List<OrderItemDto> orderInfo) throws Exception {
		return orderMapper.insertOrderDetail(orderInfo);
	}


}
