package com.team.cwl.cart;

import java.util.List;


import org.mybatis.spring.annotation.MapperScan;


@MapperScan(basePackages = "CartMapper")
public interface CartMapper {
	/* īƮ �߰� */
	public int cartAdd(CartDTO cart) throws Exception;
	
	/* īƮ ���� */
	public int cartDelete(Long cartNum);
	
	/* īƮ ���� ���� */
	public int modifyCount(CartDTO cart);
	
	/* īƮ ��� */
	public List<CartDTO> cartList(String memberId);	
	
	/* īƮ Ȯ�� */
	public CartDTO checkCart(CartDTO cart);		
	
	/* īƮ ����(�ֹ�) */
	public int deleteOrderCart(CartDTO dto);	
}