package pj1.service;

import java.util.List;

import pj1.dto.MemberDto;
import pj1.vo.RequestVo;
import pj1.vo.ResponseVo;

public interface MemberService {
	public List<MemberDto> selectMemberList() throws Exception;
	public int insertMember(MemberDto member) throws Exception;
    public ResponseVo login(RequestVo requestVo) throws Exception;
    public MemberDto selectDetailMember(String memEmail) throws Exception;
}
