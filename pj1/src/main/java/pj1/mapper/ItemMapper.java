package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.ItemDto;

@Mapper
public interface ItemMapper {
	List<ItemDto> selectItemList() throws Exception;
	
	List<ItemDto> selectItemTop() throws Exception;
	
	ItemDto selectItemDetail(String itemNum) throws Exception;
}
