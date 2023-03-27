package com.team.cwl.members;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/members/**")
public class MemberControllers {

	private static final Logger logger = LoggerFactory.getLogger(MemberControllers.class);
	
	@Autowired
	private MemberServices memberServices;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	// ȸ������ ������ �̵�
	@RequestMapping(value = "memberAdd", method = RequestMethod.GET)
	public void loginGET() {
		logger.info("ȸ������ ������ ����");
	}
	
	// ȸ������
	public String addPOST(MemberDTOS member) throws Exception {
		
		String rawPw = ""; // ���ڵ� �� ��й�ȣ
		String encodePw = ""; // ���ڵ� �� ��й�ȣ
		
		rawPw = member.getMemberPw(); // ��й�ȣ ������ ����
		encodePw = pwEncoder.encode(rawPw); // ��й�ȣ ���ڵ�
		member.setMemberPw(encodePw); // ���ڵ��� ��й�ȣ member ��ü�� �ٽ� ����
		
		/* ȸ������ ���� ���� */
		memberServices.memberAdd(member);
		
		return "redirect:/";		
	}
	
	// �α��� ������ �̵�
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public void addGET() {
		logger.info("�α��� ������ ����");
	}

	// ���̵� �ߺ� üũ
	@RequestMapping(value = "memberIdCheck", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdCheckPOST(String memberId) throws Exception {
		
		logger.info("memberIdCheck() ����");
		
		int result = memberServices.idCheck(memberId);
		
		logger.info("����� = " + result);
		
		if(result != 0) {
			return "fail"; // �ߺ� ���̵� ����
		} else {
			return "success"; // �ߺ� ���̵� ����
		}
	} // memberIdCheckPOST() ����
	
	/* �α��� */
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberDTOS member, RedirectAttributes rttr) throws Exception {
		
		HttpSession session = request.getSession();
		String rawPw = "";
		String encodePw = "";
		
		MemberDTOS membercheck = memberServices.memberLogin(member); // ������ ���̵�� ��ġ�� ���̵� �ִ��� Ȯ��
		
		if(membercheck != null) { // ��ġ�ϴ� ���̵� �����
			rawPw = member.getMemberPw(); // ����ڰ� ������ ��й�ȣ
			encodePw = membercheck.getMemberPw(); // DB�� ������ ���ڵ��� ��й�ȣ
			
			if(true == pwEncoder.matches(rawPw, encodePw)) { // ��й�ȣ ��ġ���� �Ǵ�
				
				membercheck.setMemberPw(""); // ���ڵ��� ��й�ȣ ���� ����
				session.setAttribute("member", membercheck); // session�� ������� ���� ����
				return "redirect:/"; // ������������ �̵�
			} else {
				rttr.addFlashAttribute("result", 0);
				return "redirect:/member/memberLogin"; // �α��� �������� �̵�
			}
		} else {									// ��ġ�ϴ� ���̵� �������� ���� ��(�α��� ����)
			rttr.addFlashAttribute("result", 0);
			return "redirect:/member/memberLogin"; // �α��� �������� �̵�
		} 
		
	}
	
	/* ���������� �α׾ƿ� */
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logoutMainGET(HttpServletRequest request) throws Exception {
		
		logger.info("logoutMainGET�޼��� ����");
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	/* �񵿱��� �α׾ƿ� �޼��� */
	@RequestMapping(value = "logout.do", method = RequestMethod.POST)
	@ResponseBody
	public void logoutPOST(HttpServletRequest request) throws Exception {
		
		logger.info("�񵿱� �α׾ƿ� �޼��� ����");
		
		HttpSession session = request.getSession();
		
		session.invalidate();
	}
	
}
