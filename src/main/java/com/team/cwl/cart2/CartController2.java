package com.team.cwl.cart2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.cwl.member.MemberDTO;


@Controller
public class CartController2 {
	
	@Autowired
	private CartServiceImpl2 cartServiceImpl2;
	
	/* ��ٱ��� �߰� */
	/**
	 * 0: ��� ����
	 * 1: ��� ����
	 * 2: ��ϵ� ������ ����
	 * 5: �α��� �ʿ�
	 * 
	 */
	@PostMapping("/cart/add2")
	@ResponseBody
	public String addCartPOST(CartDTO2 cart, HttpServletRequest request) {
		// �α��� üũ
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		if(memberDTO == null) {
			return "5";
		}
		
		// īƮ ���
		
		int result = cartServiceImpl2.addCart(cart);
		
		return result + "";
	}	
	
	/* ��ٱ��� ������ �̵� */	
	@GetMapping("/cart/{memberId}")
	public String getCartList(@PathVariable("memberId") String memberId, Model model) {
		
		model.addAttribute("cartInfo", cartServiceImpl2.getCartList(memberId));
		
		return "/cart";
	}	
	
	/* ��ٱ��� ���� ���� */
	@PostMapping("/cart/update2")
	public String updateCartPOST(CartDTO2 cart) {
		
		cartServiceImpl2.modifyCount(cart);
		
		return "redirect:/cart/" + cart.getMemberId();
		
	}	
	
	/* ��ٱ��� ���� ���� */
	@PostMapping("/cart/delete")
	public String deleteCartPOST(CartDTO2 cart) {
		
		cartServiceImpl2.deleteCart(cart.getCartNum());
		
		return "redirect:/cart/" + cart.getMemberId();
		
	}		
}
