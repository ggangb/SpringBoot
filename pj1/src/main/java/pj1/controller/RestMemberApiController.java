package pj1.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import pj1.dto.MemberDto;
import pj1.service.MemberService;
import pj1.vo.RequestVo;
import pj1.vo.ResponseVo;

@Slf4j
@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class RestMemberApiController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public List<MemberDto> openMemberList() throws Exception {
		return memberService.selectMemberList();
	}
	
	
	@RequestMapping(value="/member/{memEmail}", method = RequestMethod.GET)
	public MemberDto openDetailMember(
			@Parameter(description = "회원 이메일", required = true, example = "이메일") @PathVariable("memEmail") String memEmail) throws Exception {
		return memberService.selectDetailMember(memEmail);
	}
	
	@RequestMapping(value="/changeAddr", method = RequestMethod.POST)
	public ResponseEntity<String> changeAddr(@RequestBody MemberDto member) throws Exception {
		System.out.println(member);
		return null;
	}
	
	
	@RequestMapping(value="/member/join", method = RequestMethod.POST)
	public ResponseEntity<String> insertMember(@RequestBody MemberDto member) throws Exception {
		
		
		System.out.println(member);

		int memIdx = memberService.insertMember(member);
		if (memIdx>0) {
			return ResponseEntity.status(HttpStatus.OK).body("등록성공");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록실패");
		}
		
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public ResponseEntity<ResponseVo> login(@RequestBody RequestVo requestVo) throws Exception {
		System.out.println(requestVo);
		ResponseVo responseVo = memberService.login(requestVo);
		if (responseVo == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			
			return ResponseEntity.status(HttpStatus.OK).body(responseVo);
		}		
	}	
	
	@RequestMapping(value="/member/{memEmail}/{memName}/{memPhone}",method = RequestMethod.GET)
	public ResponseEntity<MemberDto> findPassword(@PathVariable("memEmail") String memEmail,@PathVariable("memName")String memName,@PathVariable("memPhone") String memPhone) throws Exception {
		MemberDto memberDto = memberService.findPassword(memEmail, memName, memPhone);
		if (memberDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}else {
			return ResponseEntity.ok(memberDto);
		}
	}
	
	@RequestMapping(value="/member/{memName}/{memPhone}",method = RequestMethod.GET)
	public ResponseEntity<MemberDto> findEmail(@PathVariable("memName") String memName,@PathVariable("memPhone") String memPhone ) throws Exception {
		System.out.println(memName);
		System.out.println(memPhone);
		
		MemberDto memberDto = memberService.findEmail(memName,memPhone);
		if (memberDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}else {
			return ResponseEntity.ok(memberDto);
		}
	}
	
	@RequestMapping(value = "/checkemail/{memEmail}",method = RequestMethod.GET)
	public ResponseEntity<MemberDto> validateMemberEmail(@PathVariable("memEmail") String memEmail) throws Exception {
		
		System.out.println(memEmail);
		
		MemberDto memberDto = memberService.validateMemberEmail(memEmail);
		if (memberDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	   } else {
		   return ResponseEntity.ok(memberDto);
	   }
		
	}
	
//	@RequestMapping(value = "/member/{memIdx}", method=RequestMethod.GET)
//	public ResponseEntity<MemberDto> selectMemberDetail(@PathVariable("memIdx")int memIdx) throws Exception{
//		MemberDto memberDto = memberService.selectMemberDetail(memIdx);
//		if(memberDto == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		}else {
//			return ResponseEntity.ok(memberDto);
//		}
//	}
	
	@RequestMapping(value = "/member/{memIdx}", method=RequestMethod.PUT)
	public void adminmemupdate(@PathVariable("memIdx") int memIdx, @RequestBody MemberDto memberDto) throws Exception{
		memberDto.setMemIdx(memIdx);
		memberService.adminmemupdate(memberDto);
	}
	
	@RequestMapping(value = "/member/{memIdx}", method=RequestMethod.DELETE)
	public void ydeleteMember(@PathVariable("memIdx") int memIdx) throws Exception{
		memberService.ydeleteMember(memIdx); 
	}


}
