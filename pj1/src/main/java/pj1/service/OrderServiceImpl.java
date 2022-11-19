package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.CartListDto;
import pj1.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public List<CartListDto> insertOrder(List<CartListDto> orderList) throws Exception {
		
		return orderMapper.insertOrder(orderList);
	}

}
