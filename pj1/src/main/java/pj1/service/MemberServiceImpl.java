package pj1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pj1.dto.MemberDto;
import pj1.mapper.MemberMapper;
import pj1.vo.RequestVo;
import pj1.vo.ResponseVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public MemberDto selectMemberDetail(int memIdx) throws Exception {
		
		return memberMapper.selectMemberDetail(memIdx);
	}

	@Override
	public void updateMemberInfo(MemberDto memberDto) throws Exception {
		int count = memberMapper.updateMemberInfo(memberDto);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public void deleteMemberInfo(int memIdx) throws Exception {
		int count = memberMapper.deleteMemberInfo(memIdx);
		System.out.println("xxxxxxxxxxxxxxxxx" + count);
	}

	@Override
	public List<MemberDto> selectMemberList() throws Exception {
		return memberMapper.selectMemberList();
	}
	
	@Override
	public int insertMember(MemberDto member) throws Exception {
		memberMapper.insertMember(member);
		return member.getMemIdx();
	}
	
	@Override
	public ResponseVo login(RequestVo requestVo) throws Exception {
		
		MemberDto memberDto = new MemberDto();
		memberDto.setMemEmail(requestVo.getMemEmail());
		memberDto.setMemPw(requestVo.getMemPw());
		
		MemberDto resultDto = memberMapper.login(memberDto);
		if (resultDto == null) 
			return null;
		
		ResponseVo responseVo = new ResponseVo();
		responseVo.setMemEmail(resultDto.getMemEmail());
		responseVo.setMemIdx(resultDto.getMemIdx());
		responseVo.setMemName(resultDto.getMemName());
		return responseVo;
	}

	@Override
	public MemberDto selectDetailMember(String memEmail) throws Exception {
		
		return memberMapper.selectDetailMember(memEmail);
	}

	
}
