package pj1.service;

import java.util.List;

import pj1.dto.OrderItemDto;
import pj1.vo.ApproveResponse;
import pj1.vo.ReadyResponse;

public interface KakaoPayService {
	public ReadyResponse payReady(List<OrderItemDto> orderInfo);
	public ApproveResponse payApprove(String pgTokend);
}
