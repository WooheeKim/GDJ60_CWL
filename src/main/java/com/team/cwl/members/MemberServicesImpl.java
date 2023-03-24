package com.team.cwl.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServicesImpl implements MemberServices {
	
	@Autowired
	MemberMapper memberMapper;
	
	/* ȸ������ */
	@Override
	public void memberAdd(MemberDTOS member) throws Exception {
		memberMapper.memberAdd(member);
	}
	
	/* ���̵� �ߺ� üũ */
	@Override
	public int idCheck(String memberId) throws Exception {
		return memberMapper.idCheck(memberId);
	}
	
	/* �α��� */
	@Override
	public MemberDTOS memberLogin(MemberDTOS member) throws Exception {
		return memberMapper.memberLogin(member);
	}
	
	/* �ֹ��� ���� */
	@Override
	public MemberDTOS getMemberInfo(String memberId) {
		return memberMapper.getMemberInfo(memberId);
	}
}
