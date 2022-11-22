package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.AdminDto;

@Mapper
public interface AdminMapper {
	
	List<AdminDto> selectAllReview() throws Exception;
	int deleteReview(int reviewIdx) throws Exception;
	int showReview(int reviewIdx) throws Exception;
	
}
