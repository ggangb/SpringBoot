package pj1.mapper;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.CartDto;

@Mapper
public interface CartMapper {
	int insertCart(CartDto cartDto) throws Exception;
}
