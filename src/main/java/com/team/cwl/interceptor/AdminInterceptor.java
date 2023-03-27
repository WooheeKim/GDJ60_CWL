package com.team.cwl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.team.cwl.members.MemberDTOS;

public class AdminInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		MemberDTOS memberDtos = (MemberDTOS)session.getAttribute("members");
		
		if(memberDtos == null || memberDtos.getAdminCheck() == 0) { // ������ ������ �ƴ� ���
			
			response.sendRedirect("/"); // Ȩ���� �����̷�Ʈ
			
			return false;
		}
		
		
		return true;  //  ������ ���� �α��� ��� (memberDTOs != null && memberDTOs.getAdmincheck() == 1)
	}
	
}
