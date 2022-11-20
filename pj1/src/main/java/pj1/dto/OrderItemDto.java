package pj1.dto;


import java.util.List;

import lombok.Data;

@Data
public class OrderItemDto {
	
	private String memEmail;
	private String address1;
	private String address2;
	private String memPhone;
	private int totalPrice;
	private int orderNum;
	private String itemNum;
	private String itemName;
	private int itemAmount;
	private String orderStatus;
	
	
}
