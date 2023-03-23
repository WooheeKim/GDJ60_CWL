package com.team.cwl.cart2;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface CartService2 {
	/* ��ٱ��� �߰� */
	public int cartAdd(CartDTO2 cart);	
	
	/* ��ٱ��� ���� ����Ʈ */
	public List<CartDTO2> cartList(String memberId);	
	
	/* īƮ ���� ���� */
	public int modifyCount(CartDTO2 cart);		
	
	/* īƮ ���� */
	public int cartDelete(Long cartId);
}