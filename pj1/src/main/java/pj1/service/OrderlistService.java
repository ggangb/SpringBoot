package pj1.service;

import java.util.List;

import pj1.dto.OrderlistDto;

public interface OrderlistService {
	
	public List<OrderlistDto> selectOrderlist(int memIdx) throws Exception;
	public List<OrderlistDto> selectMyRefund(int memIdx) throws Exception;
	public List<OrderlistDto> selectAbleReview(int memIdx) throws Exception;
	public void insertReview(OrderlistDto orderlistDto) throws Exception;
	public List<OrderlistDto> selectDidReview(int memIdx) throws Exception;
	public OrderlistDto selectReviewDetail(int reviewIdx) throws Exception;
	public void updateReview(OrderlistDto orderlistDto) throws Exception;
	public void orderCancelNow(int orderNum) throws Exception;
	public void orderCancelPlz(int orderNum) throws Exception;
	public void itemPurchase(int orderNum) throws Exception;
	public int insertAbleReview(OrderlistDto orderlistDto) throws Exception;
	public void updateRefund(int orderNum) throws Exception;
	public int insertMyRefund(OrderlistDto orderlistDto) throws Exception;
	public void updateRefundCancel(int orderNum) throws Exception;
	public void deleteRefund(int refundIdx) throws Exception;
	
}
