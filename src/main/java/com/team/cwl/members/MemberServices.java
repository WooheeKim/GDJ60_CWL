package com.team.cwl.members;

public interface MemberServices {
	
	/* ȸ������ */
	public void memberAdd(MemberDTOS member) throws Exception;
	
	/*���̵� �ߺ� �˻�*/
	public int idCheck(String memberId) throws Exception;
	
	/* �α��� */
	public MemberDTOS memberLogin(MemberDTOS member) throws Exception;
	
	/* �ֹ��� ���� */
	public MemberDTOS getMemberInfo(String memberId);
}
