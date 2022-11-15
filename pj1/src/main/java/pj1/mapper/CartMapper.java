package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.CartDto;
import pj1.dto.CartListDto;

@Mapper
public interface CartMapper {
	int insertCart(CartDto cartDto) throws Exception;
	List<CartListDto> selectCartList(String memEmail) throws Exception;
}
