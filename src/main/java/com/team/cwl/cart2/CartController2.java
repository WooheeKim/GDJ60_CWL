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
	
	/* 장바구니 추가 */
	/**
	 * 0: 등록 실패
	 * 1: 등록 성공
	 * 2: 등록된 데이터 존재
	 * 5: 로그인 필요
	 * 
	 */
	@PostMapping("cartAdd")
	@ResponseBody
	public String cartAdd(CartDTO2 cart, HttpServletRequest request) {
		// 로그인 체크
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		if(memberDTO == null) {
			return "5";
		}
		
		// 카트 등록
		
		int result = cartServiceImpl2.cartAdd(cart);
		
		return result + "";
	}	
	
	/* 장바구니 페이지 이동 */
	@GetMapping("{memberId}")
	public String cartList(@PathVariable("memberId") String memberId, Model model) {
		
		model.addAttribute("cartInfo", cartServiceImpl2.cartList(memberId));
		
		return "/cart/cart";
	}	
	
	/* 장바구니 수량 수정 */
	@PostMapping("cartUpdate")
	public String cartUpdate(CartDTO2 cart) {
		
		cartServiceImpl2.modifyCount(cart);
		
		return "redirect:/cart/cart" + cart.getMemberId();
		
	}	
	
	/* 장바구니 수량 삭제 */
	@PostMapping("cartDelete")
	public String cartDelete(CartDTO2 cart) {
		
		cartServiceImpl2.cartDelete(cart.getCartNum());
		
		return "redirect:/cart/cart" + cart.getMemberId();
		
	}		
}