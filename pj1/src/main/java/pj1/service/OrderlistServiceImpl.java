package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.OrderItemDto;
import pj1.dto.OrderlistDto;
import pj1.mapper.OrderlistMapper;

@Service
public class OrderlistServiceImpl implements OrderlistService {

	@Autowired
	private OrderlistMapper orderlistMapper;
	
	@Override
	public List<OrderlistDto> selectOrderlist(int memIdx) throws Exception {
		return orderlistMapper.selectOrderlist(memIdx);
	}

	@Override
	public List<OrderlistDto> selectRefund(int memIdx) throws Exception {
		return orderlistMapper.selectRefund(memIdx);
	}

	@Override
	public List<OrderlistDto> selectAbleReview(int memIdx) throws Exception {
		return orderlistMapper.selectAbleReview(memIdx);
	}

	@Override
	public void insertReview(OrderlistDto orderlistDto) throws Exception {
		int count = orderlistMapper.insertReview(orderlistDto);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public List<OrderlistDto> selectDidReview(int memIdx) throws Exception {
		return orderlistMapper.selectDidReview(memIdx);
	}

	@Override
	public OrderlistDto selectReviewDetail(int reviewIdx) throws Exception {
		return orderlistMapper.selectReviewDetail(reviewIdx);
	}

	@Override
	public void updateReview(OrderlistDto orderlistDto) throws Exception {
		int count = orderlistMapper.updateReview(orderlistDto);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public void orderCancelNow(int orderlistIdx) throws Exception {
		int count = orderlistMapper.orderCancelNow(orderlistIdx);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}
	
	@Override
	public void orderCancelPlz(int orderlistIdx) throws Exception {
		int count = orderlistMapper.orderCancelPlz(orderlistIdx);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public void itemPurchase(int orderlistIdx) throws Exception {
		int count = orderlistMapper.itemPurchase(orderlistIdx);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public int insertAbleReview(OrderlistDto orderlistDto) throws Exception {
			orderlistMapper.insertAbleReview(orderlistDto);
		return 1;
	}

	@Override
	public int orderDelete(String orderNum) throws Exception {
		
		return orderlistMapper.orderDelete(orderNum);
	}

	@Override
	public int orderListDelete(String orderNum) throws Exception {
		
		return orderlistMapper.orderListDelete(orderNum);
	}

	
	@Override
	public void updateRefund(int orderNum) throws Exception {
		int count = orderlistMapper.updateRefund(orderNum);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public String insertMyRefund(OrderlistDto orderlistDto) throws Exception {
			orderlistMapper.insertMyRefund(orderlistDto);
		return orderlistDto.getOrderNum();
	}

	@Override
	public void updateRefundCancel(int orderNum) throws Exception {
		int count = orderlistMapper.updateRefundCancel(orderNum);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public void deleteRefund(int refundIdx) throws Exception {
		int count = orderlistMapper.deleteRefund(refundIdx);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}
	
	
	
	
//admin
	@Override
	public int orderState(int orderlistIdx) throws Exception {
		return orderlistMapper.orderState(orderlistIdx);
	}

	@Override
	public int orderStateDelivery(int orderlistIdx) throws Exception {
		return orderlistMapper.orderStateDelivery(orderlistIdx);
	}

	@Override
	public int orderStateComple(int orderlistIdx) throws Exception {
		return orderlistMapper.orderStateComple(orderlistIdx);
	}

	@Override
	public List<OrderItemDto> selectAllOrderlist() throws Exception {
		return orderlistMapper.selectAllOrderlist();
	}

}
