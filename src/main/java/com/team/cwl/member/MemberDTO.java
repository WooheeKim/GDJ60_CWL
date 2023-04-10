package com.team.cwl.member;

public class MemberDTO {
	
	//회원 ID
	private String memberId;
	
	// 회원 닉네임
	private String memberNickName;
	
	//회원 PW
	private String memberPw;
	
	// 회원 이름
	private String memberName;
	
	// 회원 휴대폰 번호
	private String memberPhone;
	
	// 회원 우편번호
	private String memberAddress1;
	
	// 회원 주소
	private String memberAddress2;
	
	// 회원 상세주소
	private String memberAddress3;
	
	//회원 이메일
	private String memberEmail;
	
	// 관리자 구분(0:일반사용자, 1:관리자)
	private Long adminCheck;
	
	// 회원 성별
	private String memberGender;
	
	// 자기소개
	private String memberSI;
	
	// 회원 나이
	private Long memberAge;
	
	// 회원이 가지고 있는 돈
	private int money;
	

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
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

	public Long getAdminCheck() {
		return adminCheck;
	}

	public void setAdminCheck(Long adminCheck) {
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

	public Long getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(Long memberAge) {
		this.memberAge = memberAge;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberNickName=" + memberNickName + ", memberPw=" + memberPw
				+ ", memberName=" + memberName + ", memberPhone=" + memberPhone + ", memberAddress1=" + memberAddress1
				+ ", memberAddress2=" + memberAddress2 + ", memberAddress3=" + memberAddress3 + ", memberEmail="
				+ memberEmail + ", adminCheck=" + adminCheck + ", memberGender=" + memberGender + ", memberSI="
				+ memberSI + ", memberAge=" + memberAge + ", money=" + money + "]";
	}

	
	
	
	
}
