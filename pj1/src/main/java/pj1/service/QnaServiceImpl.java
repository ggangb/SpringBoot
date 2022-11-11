package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.QnaDto;
import pj1.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {
	@Autowired
	private QnaMapper qnaMapper;
	
	@Override
	public List<QnaDto> selectQnaList() throws Exception {
		return qnaMapper.selectQnaList();
	}

	@Override
	public QnaDto selectQnaDetail(int qnaIdx) throws Exception {
		return qnaMapper.selectQnaDetail(qnaIdx);
	}

	@Override
	public QnaDto selectQnaAnswer(int qnaIdx) throws Exception {
		
		return qnaMapper.selectQnaAnswer(qnaIdx);
	}
}
