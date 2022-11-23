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

import pj1.dto.AdminDto;
import pj1.service.AdminService;
import pj1.service.OrderlistService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/admin/review", method = RequestMethod.GET)
	public List<AdminDto> selectAllReview() throws Exception { 
		return adminService.selectAllReview();
	}
	
	@RequestMapping(value = "/admin/review/remove/{reviewIdx}", method = RequestMethod.DELETE)
	public void deleteReview(@PathVariable("reviewIdx") int reviewIdx) throws Exception{
		adminService.deleteReview(reviewIdx);
	}
	
	@RequestMapping(value = "/admin/review/show/{reviewIdx}", method = RequestMethod.DELETE)
	public void showReview(@PathVariable("reviewIdx") int reviewIdx) throws Exception{
		adminService.showReview(reviewIdx);
	}
	
	
	@RequestMapping(value = "/admin/refund", method = RequestMethod.GET)
	public List<AdminDto> selectAllRefund() throws Exception { 
		return adminService.selectAllRefund();
	}
	
	@RequestMapping(value = "/admin/refund/{refundIdx}", method = RequestMethod.PUT)
	public void updateStatus(@PathVariable("refundIdx") int refundIdx) throws Exception {
		adminService.updateStatus(refundIdx);
	}
	
}
