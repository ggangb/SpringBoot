package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.ReviewDto;

@Mapper
public interface ReviewMapper {
	List<ReviewDto> selectReviewList() throws Exception;
	
	ReviewDto selectReviewDetail(int reviewIdx) throws Exception;
}
