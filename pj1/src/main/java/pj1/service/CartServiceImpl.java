package pj1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.CartDto;
import pj1.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public int insertCart(CartDto cartDto) throws Exception {
		
		return cartMapper.insertCart(cartDto);
	}

}
