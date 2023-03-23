package com.team.cwl.cart2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CartServiceImpl2 implements CartService2 {
	
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public int cartAdd(CartDTO2 cart) {

		// ��ٱ��� ������ üũ
		CartDTO2 checkCart = cartMapper.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		
		// ��ٱ��� ��� & ���� �� 0��ȯ
		try {
			return cartMapper.cartAdd(cart);
		} catch (Exception e) {
			return 0;
		}		
		
	}

	@Override
	public List<CartDTO2> cartList(String memberId) {
		
		List<CartDTO2> cart = cartMapper.cartList(memberId);
		
		for(CartDTO2 dto : cart) {
			
			/* ���� ���� �ʱ�ȭ */
			dto.initTotal();
			
		}
		
		return cart;
		
	}
	
	@Override
	public int modifyCount(CartDTO2 cart) {	
		return cartMapper.modifyCount(cart);
	}	
	
	@Override
	public int cartDelete(Long cartId) {
		return cartMapper.cartDelete(cartId);
	}	
	
}
