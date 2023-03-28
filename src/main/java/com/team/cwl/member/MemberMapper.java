package com.team.cwl.member;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "MemberMapper")
public interface MemberMapper {
	
	/* ȸ������ */
	public void memberAdd(MemberDTO member);

	/* ���̵� �ߺ� �˻� */
	public int idCheck(String memberId);
	
	/* �α��� */
	public MemberDTO memberLogin(MemberDTO member);
	
	/* �ֹ��� �ּ� ���� */
	public MemberDTO getMemberInfo(String memberId);
	
	public MemberDTO getMemberPage(MemberDTO memberDTO);
	
}
