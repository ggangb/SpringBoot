package pj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pj1.dto.OrderItemDto;
import pj1.dto.OrderlistDto;
import pj1.service.OrderlistService;

@RestController
public class OrderlistController {

	@Autowired
	private OrderlistService orderlistService;

	@RequestMapping(value = "/mypage/myorderlist/{memIdx}", method = RequestMethod.GET)
	public List<OrderlistDto> showOrderlist(@PathVariable("memIdx") int memIdx) throws Exception {

		return orderlistService.selectOrderlist(memIdx);
	}

	@RequestMapping(value = "/mypage/myrefund/{memIdx}", method = RequestMethod.GET)
	public List<OrderlistDto> showRefund(@PathVariable("memIdx") int memIdx) throws Exception {

		return orderlistService.selectRefund(memIdx);
	}

	@RequestMapping(value = "/mypage/myreview/able/{memIdx}", method = RequestMethod.GET)
	public List<OrderlistDto> showAbleReview(@PathVariable("memIdx") int memIdx) throws Exception {

		return orderlistService.selectAbleReview(memIdx);
	}

	@RequestMapping(value = "/mypage/myreview/write/{orderlistIdx}", method = RequestMethod.PUT)
	public void createReview(@PathVariable("orderlistIdx") int orderlistIdx, @RequestBody OrderlistDto orderlistDto)
			throws Exception {
		orderlistService.insertReview(orderlistDto);
		
	}

	@RequestMapping(value = "/mypage/myreview/did/{memIdx}", method = RequestMethod.GET)
	public List<OrderlistDto> showDidReview(@PathVariable("memIdx") int memIdx) throws Exception {

		return orderlistService.selectDidReview(memIdx);
	}

	@RequestMapping(value = "/mypage/myreview/modify/{reviewIdx}", method = RequestMethod.GET)
	public ResponseEntity<OrderlistDto> openReviewDetail(@PathVariable("reviewIdx") int reviewIdx) throws Exception {
		OrderlistDto orderlistDto = orderlistService.selectReviewDetail(reviewIdx);
		if (orderlistDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.ok(orderlistDto);
		}
	}

	@RequestMapping(value = "/mypage/myreview/modify/{reviewIdx}", method = RequestMethod.PUT)
	public void modifyReview(@PathVariable("reviewIdx") int reviewIdx, @RequestBody OrderlistDto orderlistDto)
			throws Exception {
		orderlistService.updateReview(orderlistDto);
	}

	@RequestMapping(value = "/mypage/myorderlist/now/{orderlistIdx}", method = RequestMethod.PUT)
	public void orderCancelNow(@PathVariable("orderlistIdx") int orderlistIdx) throws Exception {
		orderlistService.orderCancelNow(orderlistIdx);
	}

	@RequestMapping(value = "/mypage/myorderlist/plz/{orderlistIdx}", method = RequestMethod.PUT)
	public void orderCancelPlz(@PathVariable("orderlistIdx") int orderlistIdx) throws Exception {
		orderlistService.orderCancelPlz(orderlistIdx);
	}
	
	@RequestMapping(value = "/mypage/myorderlist/delete/{orderNum}", method = RequestMethod.PUT)
	public void orderDelete(@PathVariable("orderNum") String orderNum) throws Exception {
		orderlistService.orderDelete(orderNum);
		orderlistService.orderListDelete(orderNum);
	}


	@RequestMapping(value = "/mypage/myorderlist/purchase/{orderlistIdx}", method = RequestMethod.PUT)
	public void itemPurchase(@PathVariable("orderlistIdx") int orderlistIdx) throws Exception {
		orderlistService.itemPurchase(orderlistIdx);
	}

	@RequestMapping(value = "/mypage/myorderlist/purchase/{orderlistIdx}", method = RequestMethod.POST)
	public ResponseEntity<String> insertAbleReview(@PathVariable("orderlistIdx") int orderlistIdx,
			@RequestBody OrderlistDto orderlistDto) throws Exception {
		int reviewIdx = orderlistService.insertAbleReview(orderlistDto);
		if (reviewIdx > 0) {
			return ResponseEntity.status(HttpStatus.OK).body("구매확정 성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("구매확정 실패");
		}
	}
	
	@RequestMapping(value = "/mypage/myorderlist/refundgo/{orderNum}", method = RequestMethod.PUT)
	public void updateRefund(@PathVariable("orderNum") int orderNum) throws Exception {
		orderlistService.updateRefund(orderNum);
	}
	
	@RequestMapping(value = "/mypage/myorderlist/refundgo/{orderNum}", method = RequestMethod.POST)
	public ResponseEntity<String> insertMyRefund(@PathVariable("orderNum") int orderNum, @RequestBody OrderlistDto orderlistDto) throws Exception {
		String refundIdx = orderlistService.insertMyRefund(orderlistDto);
		System.out.println(refundIdx);
		if(refundIdx != null) {
			return ResponseEntity.status(HttpStatus.OK).body("반품접수 성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("반품접수 실패");
		}
	}
	
	@RequestMapping(value = "/mypage/myrefund/refundcancel/{orderNum}", method = RequestMethod.PUT)
	public void updateRefundCancel(@PathVariable("orderNum") int orderNum) throws Exception {
		orderlistService.updateRefundCancel(orderNum);
	}
	
	@RequestMapping(value = "/mypage/myrefund/removerefund/{refundIdx}", method = RequestMethod.PUT)
	public void deleteRefund(@PathVariable("refundIdx") int refundIdx) throws Exception {
		orderlistService.deleteRefund(refundIdx);
	}
	
	

	// admin
	@RequestMapping(value = "/admin/order/{orderlistIdx},{stateSelect}", method = RequestMethod.POST)
	public void orderState(@PathVariable("orderlistIdx") int orderlistIdx ,@PathVariable("stateSelect")String state) throws Exception {
		
		
		switch (state) {
		case "상품준비중":		
			orderlistService.orderState(orderlistIdx);
			break;
		case "배송중":		
			orderlistService.orderStateDelivery(orderlistIdx);
			break; // 종료
		case "배송완료":
			orderlistService.orderStateComple(orderlistIdx);
			break;
		default:
		}
		System.out.println(orderlistIdx);
		System.out.println(state);
		
		
	}

	@RequestMapping(value = "/admin/order", method = RequestMethod.GET)
	public List<OrderItemDto> adminOrderlist() throws Exception {
		return orderlistService.selectAllOrderlist();
	}

}
