package com.team.cwl.cart2;

import java.util.List;


import org.mybatis.spring.annotation.MapperScan;


@MapperScan(basePackages = "CartMapper")
public interface CartMapper {
	/* īƮ �߰� */
	public int cartAdd(CartDTO2 cart) throws Exception;
	
	/* īƮ ���� */
	public int cartDelete(Long cartId);
	
	/* īƮ ���� ���� */
	public int modifyCount(CartDTO2 cart);
	
	/* īƮ ��� */
	public List<CartDTO2> cartList(String memberId);	
	
	/* īƮ Ȯ�� */
	public CartDTO2 checkCart(CartDTO2 cart);		
	
	/* īƮ ����(�ֹ�) */
	public int deleteOrderCart(CartDTO2 dto);	
}