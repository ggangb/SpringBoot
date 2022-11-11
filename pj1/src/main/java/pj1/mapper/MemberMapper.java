package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.MemberDto;
import pj1.vo.RequestVo;
import pj1.vo.ResponseVo;

@Mapper
public interface MemberMapper {
	List<MemberDto> selectMemberList() throws Exception;
	int insertMember(MemberDto member) throws Exception;
	MemberDto login(MemberDto memberDto) throws Exception;
	ResponseVo login(RequestVo requestVo) throws Exception;
	
}