package com.team.cwl.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart/**")
public class CartController { 
	
	@Autowired(required=false)
	private CartService cartService;
	
	@RequestMapping(value = "add")
	public ModelAndView setCartAdd(@ModelAttribute CartDTO cartDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		String memberId = (String)session.getAttribute("memberId");
		
		String message = "";
		
		if(memberId == null) {
			message = "�α��� �� �̿��� �����մϴ�.";
			
		}
		cartDTO.setMemberId(memberId);
		cartService.setCartAdd(cartDTO);
		
		modelAndView.addObject("result", message);
		modelAndView.setViewName("redirect:/cart/list");
		return modelAndView;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getCartList(HttpSession session, ModelAndView modelAndView) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String memeberId = (String)session.getAttribute("memberId");
		
		if(memeberId != null) {
			List<CartDTO> list = cartService.getCartList(memeberId); // ��ٱ��� ���
			int sumMoney = cartService.sumMoney(memeberId); // �ݾ� �հ�
			int fee = sumMoney >= 30000 ? 0 : 2500; // 3���� �̻��̸� ��۷� 0��, �̸��̸� 2500��
			
			// HashMap�� ��ٱ��Ͽ� ���� ���� ������ ����
			map.put("sumMoney", sumMoney);
			map.put("fee", fee); // ��۷�
			map.put("sum", sumMoney+fee); // ��ü �ݾ�
			map.put("list", list); // ��ٱ��� ���
			map.put("count", list.size()); // ���ڵ� ����
			
			modelAndView.setViewName("/cart/list"); // �̵��� �������� �̸�
			modelAndView.addObject("map", map); // ������ ����
			
			return modelAndView;
		} else {
			// �α����� ���� �ʾ����� �α��� �������� �̵�
			return new ModelAndView("/member/memberLogin", "", null);
		}
	}
	
	@RequestMapping(value = "delete")
	public String delete(@RequestParam Long cartNum) throws Exception {
		cartService.setCartDelete(cartNum);
		return "redirect:/cart/list";
	}
	
	@RequestMapping(value = "deleteAll")
	public String deleteAll(HttpSession session) throws Exception {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId != null) {
			cartService.setCartDeleteAll(memberId);
		}
		return "redirect:/cart/list";
	}
	
}
