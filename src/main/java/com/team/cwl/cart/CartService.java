package com.team.cwl.cart;

import java.util.List;


public interface CartService {
	/* ��ٱ��� �߰� */
	public int cartAdd(CartDTO cart);	
	
	/* ��ٱ��� ���� ����Ʈ */
	public List<CartDTO> cartList(String memberId);	
	
	/* īƮ ���� ���� */
	public int modifyCount(CartDTO cart);		
	
	/* īƮ ���� */
	public int cartDelete(Long cartNum);
}