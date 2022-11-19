package pj1.dto;

import lombok.Data;

@Data
public class OrderItemDto {
	private int orderNum;
	private String memEmail;
	private String orderDate;
	private String address1;
	private String address2;
	private String address3;
	
}
