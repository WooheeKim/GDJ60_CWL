package com.team.cwl.members;

public interface MemberMapper {
	
	/* ȸ������ */
	public void memberAdd(MemberDTOS member);

	/* ���̵� �ߺ� �˻� */
	public int idCheck(String memberId);
	
	/* �α��� */
	public MemberDTOS memberLogin(MemberDTOS member);
	
	/* �ֹ��� �ּ� ���� */
	public MemberDTOS getMemberInfo(String memberId);	
	
}
