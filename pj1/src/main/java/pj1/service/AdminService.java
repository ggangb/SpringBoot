package pj1.service;

import java.util.List;

import pj1.dto.AdminDto;

public interface AdminService {
	
	public List<AdminDto> selectAllReview() throws Exception;
	public void deleteReview(int reviewIdx) throws Exception;
	public void showReview(int reviewIdx) throws Exception;
	public List<AdminDto> selectAllRefund() throws Exception;
	public void updateStatus(int refundIdx) throws Exception;
	
}
