package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void orderCancelNow(int orderNum) throws Exception {
		int count = orderlistMapper.orderCancelNow(orderNum);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}
	
	@Override
	public void orderCancelPlz(int orderNum) throws Exception {
		int count = orderlistMapper.orderCancelPlz(orderNum);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public void itemPurchase(int orderNum) throws Exception {
		int count = orderlistMapper.itemPurchase(orderNum);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public int insertAbleReview(OrderlistDto orderlistDto) throws Exception {
			orderlistMapper.insertAbleReview(orderlistDto);
		return orderlistDto.getOrderNum();
	}

}
