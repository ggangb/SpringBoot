package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.ItemDto;
import pj1.mapper.ItemMapper;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public List<ItemDto> selectItemList() throws Exception {
		return itemMapper.selectItemList();
	}
	
	@Override
	public List<ItemDto> selectItemTop() throws Exception {
		return itemMapper.selectItemTop();
	}
	
	@Override
	public ItemDto selectItemDetail(String itemNum) throws Exception {
		return itemMapper.selectItemDetail(itemNum);
	}
}
