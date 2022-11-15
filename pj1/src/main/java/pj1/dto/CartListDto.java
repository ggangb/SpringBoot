package pj1.dto;

import lombok.Data;

@Data
public class CartListDto {
	
	private int cartIdx;
	private int itemAmount;
	private String itemName;
	private String itemPrice;
	private String itemThumb;
	
}
