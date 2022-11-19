package pj1.service;

import java.util.List;

import pj1.dto.CartListDto;

public interface OrderService {
	public List<CartListDto> insertOrder(List<CartListDto> orderList) throws Exception;
}
