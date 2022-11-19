package pj1.dto;

import java.util.List;

import lombok.Data;

@Data
public class CartListDto {
	
	private int cartIdx;
	private String memEmail;
	private int itemAmount;
	private String itemNum;
	private String itemName;
	private String itemPrice;
	private String itemThumb;
	
}
