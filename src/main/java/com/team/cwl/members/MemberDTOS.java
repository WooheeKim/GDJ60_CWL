package com.team.cwl.members;

public class MemberDTOS {
	
	//ȸ�� ID
	private String memberId;
	
	//ȸ�� PW
	private String memberPw;
	
	// ȸ�� �̸�
	private String memberName;
	
	// ȸ�� �޴��� ��ȣ
	private String memberPhone;
	
	// ȸ�� �����ȣ
	private String memberAddress1;
	
	// ȸ�� �ּ�
	private String memberAddress2;
	
	// ȸ�� ���ּ�
	private String memberAddress3;
	
	//ȸ�� �̸���
	private String memberEmail;
	
	// ������ ����(0:�Ϲݻ����, 1:������)
	private int adminCheck;
	
	// ȸ�� ����
	private String memberGender;
	
	// �ڱ�Ұ�
	private String memberSI;
	
	// ȸ�� ����
	private int memberAge;
	
	// ȸ���� ������ �ִ� ��
	private int money;
	
	// ������ �̸��� ��ȣ
	private int profileEmojiNum;
	

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddress1() {
		return memberAddress1;
	}

	public void setMemberAddress1(String memberAddress1) {
		this.memberAddress1 = memberAddress1;
	}

	public String getMemberAddress2() {
		return memberAddress2;
	}

	public void setMemberAddress2(String memberAddress2) {
		this.memberAddress2 = memberAddress2;
	}

	public String getMemberAddress3() {
		return memberAddress3;
	}

	public void setMemberAddress3(String memberAddress3) {
		this.memberAddress3 = memberAddress3;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getAdminCheck() {
		return adminCheck;
	}

	public void setAdminCheck(int adminCheck) {
		this.adminCheck = adminCheck;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberSI() {
		return memberSI;
	}

	public void setMemberSI(String memberSI) {
		this.memberSI = memberSI;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getProfileEmojiNum() {
		return profileEmojiNum;
	}

	public void setProfileEmojiNum(int profileEmojiNum) {
		this.profileEmojiNum = profileEmojiNum;
	}

	
	@Override
	public String toString() {
		return "MemberDTOS [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberPhone=" + memberPhone + ", memberAddress1=" + memberAddress1 + ", memberAddress2=" + memberAddress2
				+ ", memberAddress3=" + memberAddress3 + ", memberEmail=" + memberEmail + ", adminCheck=" + adminCheck + ", memberGender=" + memberGender + ", memberSI=" + memberSI
				 + ", memberAge=" + memberAge + ", money=" + money + ", profileEmojiNum=" + profileEmojiNum + "]";
	}
	
	
}
