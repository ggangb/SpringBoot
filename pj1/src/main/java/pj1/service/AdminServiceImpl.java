package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.AdminDto;
import pj1.dto.ItemDto;
import pj1.mapper.AdminMapper;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public List<AdminDto> selectAllReview() throws Exception {
		
		return adminMapper.selectAllReview();
	}

	@Override
	public void deleteReview(int reviewIdx) throws Exception {
		adminMapper.deleteReview(reviewIdx);
	}

	@Override
	public void showReview(int reviewIdx) throws Exception {
		adminMapper.showReview(reviewIdx);
	}

	@Override
	public List<AdminDto> selectAllRefund() throws Exception {
		
		return adminMapper.selectAllRefund();
	}

	@Override
	public void updateStatus(int refundIdx) throws Exception {
		adminMapper.updateStatus(refundIdx);
	}

	@Override
	public List<ItemDto> selectAdminItemList() throws Exception {
		return adminMapper.selectAdminItemList();
	}

	@Override
	public ItemDto deleteItem(String itemNum) throws Exception {	
		return adminMapper.deleteItem(itemNum);
	}

}
