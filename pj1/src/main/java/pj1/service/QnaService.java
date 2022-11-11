package pj1.service;

import java.util.List;

import pj1.dto.QnaDto;

public interface QnaService {

	public List<QnaDto> selectQnaList() throws Exception;
	
	public QnaDto selectQnaDetail(int qnaIdx) throws Exception;
	
	public QnaDto selectQnaAnswer(int qnaIdx) throws Exception;
	
}
