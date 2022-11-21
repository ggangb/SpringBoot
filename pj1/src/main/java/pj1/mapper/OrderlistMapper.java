package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.OrderItemDto;
import pj1.dto.OrderlistDto;

@Mapper
public interface OrderlistMapper {

	List<OrderlistDto> selectOrderlist(int memIdx) throws Exception;
	List<OrderItemDto> selectAllOrderlist() throws Exception; //admin
	List<OrderlistDto> selectRefund(int memIdx) throws Exception;
	List<OrderlistDto> selectAbleReview(int memIdx) throws Exception;
	int insertReview(OrderlistDto orderlistDto) throws Exception;
	List<OrderlistDto> selectDidReview(int memIdx) throws Exception;
	OrderlistDto selectReviewDetail(int reviewIdx) throws Exception;
	int updateReview(OrderlistDto orderlistDto) throws Exception;
	int orderCancelNow(String orderNum) throws Exception;
	int orderCancelPlz(int orderNum) throws Exception;
	int itemPurchase(int orderNum) throws Exception;
	int insertAbleReview(OrderlistDto orderlistDto) throws Exception;
	
	int orderListDelete(String orderNum) throws Exception;
	
	//admin
	int orderDelete(String orderNum) throws Exception;
	int orderState(String orderNum) throws Exception;
	int orderStateDelivery(String orderNum) throws Exception;
	int orderStateComle(String orderNum) throws Exception;
	
	
}
