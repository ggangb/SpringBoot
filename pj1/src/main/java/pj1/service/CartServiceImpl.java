package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.CartDto;
import pj1.dto.CartListDto;
import pj1.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public int insertCart(CartDto cartDto) throws Exception {
		
		return cartMapper.insertCart(cartDto);
	}

	@Override
	public List<CartListDto> selectCartList(String memEmail) throws Exception {
		return cartMapper.selectCartList(memEmail);
	}

}
