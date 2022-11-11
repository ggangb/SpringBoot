package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.QnaDto;

@Mapper
public interface QnaMapper {
	List<QnaDto> selectQnaList() throws Exception;
	
	QnaDto selectQnaDetail(int qnaIdx) throws Exception;
	
	QnaDto selectQnaAnswer(int qnaIdx) throws Exception;
}
