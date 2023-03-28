package com.team.cwl.member;

public interface MemberService {
	
	/* ȸ������ */
	public void memberAdd(MemberDTO member) throws Exception;
	
	/*���̵� �ߺ� �˻�*/
	public int idCheck(String memberId) throws Exception;
	
	/* �α��� */
	public MemberDTO memberLogin(MemberDTO member) throws Exception;
	
	/* �ֹ��� ���� */
	public MemberDTO getMemberInfo(String memberId);
	
	public MemberDTO getMemberPage(MemberDTO memberDTO) throws Exception;
}
