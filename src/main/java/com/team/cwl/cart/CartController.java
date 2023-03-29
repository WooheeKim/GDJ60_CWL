package com.team.cwl.cart;

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
public class CartController {
	
	@Autowired
	private CartService cartService;
	
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
	public String cartAdd(CartDTO cart, HttpServletRequest request) {
		// �α��� üũ
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		if(memberDTO == null) {
			return "5";
		}
		
		// īƮ ���
		
		int result = cartService.cartAdd(cart);
		
		return result + "";
	}	
	
	/* ��ٱ��� ������ �̵� */
	@GetMapping("{memberId}")
	public String cartList(@PathVariable("memberId") String memberId, Model model) {
		
		model.addAttribute("cartInfo", cartService.cartList(memberId));
		
		return "/cart/cart";
	}	
	
	/* ��ٱ��� ���� ���� */
	@PostMapping("cartUpdate")
	public String cartUpdate(CartDTO cart) {
		
		cartService.modifyCount(cart);
		
		return "redirect:/cart/cart" + cart.getMemberId();
		
	}	
	
	/* ��ٱ��� ���� ���� */
	@PostMapping("cartDelete")
	public String cartDelete(CartDTO cart) {
		
		cartService.cartDelete(cart.getCartNum());
		
		return "redirect:/cart/cart" + cart.getMemberId();
		
	}		
}