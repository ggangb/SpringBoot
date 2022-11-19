package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.CartListDto;

@Mapper
public interface OrderMapper {
	
	List<CartListDto> insertOrder(List<CartListDto> orderList) throws Exception;

}
