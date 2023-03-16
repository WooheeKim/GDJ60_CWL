package com.team.cwl.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart/*")
public class CartController {
	
	@Autowired(required=false)
	private CartService cartService;
	
	@RequestMapping(value = "insert")
	public String insert(@ModelAttribute CartDTO cartDTO, HttpSession session) {
		
		String memberId = (String)session.getAttribute("memberId");
		if(memberId == null) {
			return "redirect:/member/memberLogin";
		}
		cartDTO.setMemberId(memberId);
		cartService.insert(cartDTO);
		return "redirect:/cwl/cart/list";
	}
	
	@RequestMapping(value = "list")
	public ModelAndView list(HttpSession session, ModelAndView modelAndView) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String memeberId = (String)session.getAttribute("memberId");
		
		if(memeberId != null) {
			List<CartDTO> list = cartService.cartList(memeberId); // ��ٱ��� ���
			int sumMoney = cartService.sumMoney(memeberId); // �ݾ� �հ�
			int fee = sumMoney >= 30000 ? 0 : 2500; // 3���� �̻��̸� ��۷� 0��, �̸��̸� 2500��
			
			// HashMap�� ��ٱ��Ͽ� ���� ���� ������ ����
			map.put("sumMoney", sumMoney);
			map.put("fee", fee); // ��۷�
			map.put("sum", sumMoney+fee); // ��ü �ݾ�
			map.put("list", list); // ��ٱ��� ���
			map.put("count", list.size()); // ���ڵ� ����
			
			modelAndView.setViewName("/cart/cartList"); // �̵��� �������� �̸�
			modelAndView.addObject("map", map); // ������ ����
			
			return modelAndView;
		} else {
			// �α����� ���� �ʾ����� �α��� �������� �̵�
			return new ModelAndView("/member/memberLogin", "", null);
		}
	}
	
	@RequestMapping(value = "delete")
	public String delete(@RequestParam Long cartNum) {
		cartService.delete(cartNum);
		return "redirect:/cwl/cart/list";
	}
	
	@RequestMapping(value = "deleteAll")
	public String deleteAll(HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId != null) {
			cartService.deleteAll(memberId);
		}
		return "redirect:/cwl/cart/list";
	}
	
}
