package pj1.service;

import java.util.List;

import pj1.dto.OrderItemDto;
import pj1.dto.OrderlistDto;

public interface OrderlistService {
	
	public List<OrderlistDto> selectOrderlist(int memIdx) throws Exception;
	public List<OrderItemDto> selectAllOrderlist() throws Exception; //admin
	public List<OrderlistDto> selectRefund(int memIdx) throws Exception;
	public List<OrderlistDto> selectAbleReview(int memIdx) throws Exception;
	public void insertReview(OrderlistDto orderlistDto) throws Exception;
	public List<OrderlistDto> selectDidReview(int memIdx) throws Exception;
	public OrderlistDto selectReviewDetail(int reviewIdx) throws Exception;
	public void updateReview(OrderlistDto orderlistDto) throws Exception;
	public void orderCancelNow(String orderNum) throws Exception;
	public void orderCancelPlz(int orderNum) throws Exception;
	public void itemPurchase(int orderNum) throws Exception;
	public int insertAbleReview(OrderlistDto orderlistDto) throws Exception;
	public int orderDelete(String orderNum) throws Exception;
	public int orderListDelete(String orderNum) throws Exception;
	
	//admin
	public int orderState(int orderlistIdx) throws Exception;
	public int orderStateDelivery(String orderNum) throws Exception;
	public int orderStateComple(String orderNum) throws Exception;
	
}
