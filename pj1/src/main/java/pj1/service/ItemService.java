package pj1.service;

import java.util.List;

import pj1.dto.ItemDto;

public interface ItemService {
	
	public List<ItemDto> selectItemList() throws Exception;
	public List<ItemDto> selectItemTop() throws Exception;
	public ItemDto selectItemDetail(String itemNum) throws Exception;
	
}
