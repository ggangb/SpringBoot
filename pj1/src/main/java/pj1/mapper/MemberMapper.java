package pj1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pj1.dto.MemberDto;
import pj1.vo.RequestVo;
import pj1.vo.ResponseVo;

@Mapper
public interface MemberMapper {
	MemberDto selectMemberDetail(int memIdx) throws Exception;	
	int updateMemberInfo(MemberDto memberDto) throws Exception;
	int deleteMemberInfo(int memIdx) throws Exception;
	List<MemberDto> selectMemberList() throws Exception;
	int insertMember(MemberDto member) throws Exception;
	MemberDto login(MemberDto memberDto) throws Exception;
	ResponseVo login(RequestVo requestVo) throws Exception;
	MemberDto selectDetailMember(String memEmail) throws Exception;
}
