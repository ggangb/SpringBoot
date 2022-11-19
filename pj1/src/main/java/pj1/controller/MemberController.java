package pj1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pj1.dto.MemberDto;
import pj1.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/member/myinfo/{memIdx}", method = RequestMethod.GET)
	public ResponseEntity<MemberDto> openMemberDetail(@PathVariable("memIdx") int memIdx) throws Exception {
		MemberDto memberDto = memberService.selectMemberDetail(memIdx);
		if (memberDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.ok(memberDto);
		}
	}

	@RequestMapping(value = "/member/updateinfo/{memIdx}", method = RequestMethod.PUT)
	public void updateMemberInfo(@PathVariable("memIdx") int memIdx, @RequestBody MemberDto memberDto) throws Exception{
		memberService.updateMemberInfo(memberDto);
	}
	
	@RequestMapping(value = "/member/comparepw/{memIdx}", method = RequestMethod.POST)
	// public ResponseEntity<Integer> comparePw(@PathVariable("memIdx") int memIdx, @PathVariable("memPw1") String memPw1) throws Exception {
	public ResponseEntity<Integer> comparePw(@PathVariable("memIdx") int memIdx, @ModelAttribute("memPw") String memPw) throws Exception {
		String memberPass = memberService.selectMemberDetail(memIdx).getMemPw();
		if(!memberPass.equals(memPw)) {
			System.out.println("입력값(memPw) : " + memPw);
			System.out.println("유저 비밀번호(memberPass) : " + memberPass);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}else {
			System.out.println("입력값(memPw) : " + memPw);
			System.out.println("유저 비밀번호(memberPass) : " + memberPass);
			return ResponseEntity.status(HttpStatus.OK).body(memIdx);
		}
	}
	
	@RequestMapping(value = "/member/delete/{memIdx}", method = RequestMethod.DELETE)
	public void deleteMemberInfo(@PathVariable("memIdx") int memIdx) throws Exception {
		memberService.deleteMemberInfo(memIdx);
	}
	
}
