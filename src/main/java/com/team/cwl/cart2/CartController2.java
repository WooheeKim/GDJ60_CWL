package com.team.cwl.cart2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.cwl.member.MemberDTO;


@Controller
@RequestMapping("/cart/*")
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
	@PostMapping("cartAdd")
	@ResponseBody
	public String cartAdd(CartDTO2 cart, HttpServletRequest request) {
		// �α��� üũ
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		if(memberDTO == null) {
			return "5";
		}
		
		// īƮ ���
		
		int result = cartServiceImpl2.cartAdd(cart);
		
		return result + "";
	}	
	
	/* ��ٱ��� ������ �̵� */
	@GetMapping("{memberId}")
	public String cartList(@PathVariable("memberId") String memberId, Model model) {
		
		model.addAttribute("cartInfo", cartServiceImpl2.cartList(memberId));
		
		return "/cart/cart";
	}	
	
	/* ��ٱ��� ���� ���� */
	@PostMapping("cartUpdate")
	public String cartUpdate(CartDTO2 cart) {
		
		cartServiceImpl2.modifyCount(cart);
		
		return "redirect:/cart/cart" + cart.getMemberId();
		
	}	
	
	/* ��ٱ��� ���� ���� */
	@PostMapping("cartDelete")
	public String cartDelete(CartDTO2 cart) {
		
		cartServiceImpl2.cartDelete(cart.getCartNum());
		
		return "redirect:/cart/cart" + cart.getMemberId();
		
	}		
}