package pj1.service;

import java.util.List;

import pj1.dto.AdminDto;
import pj1.dto.ItemDto;

public interface AdminService {
	
	public List<AdminDto> selectAllReview() throws Exception;
	public void deleteReview(int reviewIdx) throws Exception;
	public void showReview(int reviewIdx) throws Exception;
	public List<AdminDto> selectAllRefund() throws Exception;
	public void updateStatus(int refundIdx) throws Exception;
	public List<ItemDto> selectAdminItemList() throws Exception;
	public ItemDto deleteItem(String itemNum) throws Exception;
	
}
