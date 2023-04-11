package pj1.service;

import java.util.List;

import pj1.dto.OrderItemDto;
import pj1.vo.ApproveResponse;
import pj1.vo.ReadyResponse;

public interface OrderService {
	public int insertOrder(OrderItemDto orderInfo) throws Exception;
	public int insertOrderDetail(List<OrderItemDto> orderInfo) throws Exception;
}
