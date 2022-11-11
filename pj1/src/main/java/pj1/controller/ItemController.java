package pj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import pj1.dto.ItemDto;
import pj1.service.ItemService;


@Slf4j
@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@ApiOperation(value = "목록 조회", notes = "등록된 아이템 목록을 조회")
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public List<ItemDto> openItemList() throws Exception {
		return itemService.selectItemList();
	}
	
	@ApiOperation(value = "상위 목록 조회", notes = "평점순 상위상품 조회")
	@RequestMapping(value = "/itemtop", method = RequestMethod.GET)
	public List<ItemDto> openItemTop() throws Exception {
		return itemService.selectItemTop();
	}
	
	@ApiOperation(value = "상품 상세 조회", notes = "등록된 상품 상세 조회")
	@RequestMapping(value = "/item/{itemNum}", method = RequestMethod.GET)
	public ResponseEntity<ItemDto> openItemDetail(
			@Parameter(description = "상품 번호", required = true, example = "1") @PathVariable("itemNum") String itemNum) throws Exception {
		ItemDto itemDto = itemService.selectItemDetail(itemNum);
		if (itemDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			// return ResponseEntity.status(HttpStatus.OK).body(boardDto);
			return ResponseEntity.ok(itemDto);
		}
	}
	
}
