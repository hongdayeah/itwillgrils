package kr.co.itwill.service;

import javax.servlet.http.HttpServletResponse;

import kr.co.itwill.member.MemberDTO;

public interface MemberService {

	// 회원가입
	public void memberJoin(MemberDTO dto) throws Exception;

	// 아이디 중복확인
	public int idCheck(String p_id) throws Exception;

	// 로그인
	public MemberDTO login(MemberDTO dto) throws Exception;

	// 회원탈퇴
	public void memberDelete(MemberDTO dto) throws Exception;

	// 회원정보 수정
	public void memberUpdate(MemberDTO dto) throws Exception;

	// 아이디 찾기
	public MemberDTO memberFindID(MemberDTO dto) throws Exception;

	// 비밀번호 찾기(이메일 발송)
	public void sendEmail(MemberDTO dto, String div) throws Exception;

	// 비밀번호 찾기
	public void memberFindPW(HttpServletResponse response, MemberDTO dto) throws Exception;
	
	// 회원정보 보기
	public MemberDTO readMember(String p_id);

}// interface end
