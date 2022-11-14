package pj1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import pj1.dto.CartDto;
import pj1.dto.MemberDto;
import pj1.service.CartService;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@ApiOperation(value = "장바구니 등록", notes = "장바구니 등록")
	@RequestMapping(value = "/cartinsert", method= RequestMethod.POST)
	public ResponseEntity<Object> insertCart(@RequestBody CartDto cartDto) throws Exception {
		
		int success = cartService.insertCart(cartDto);
		
		if (success > 0) {
			return ResponseEntity.status(HttpStatus.OK).body("등록성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록실패");
		}
		
	}
	
}
