package com.team.cwl.cart2;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface CartMapper2 {
	/* īƮ �߰� */
	public int addCart(CartDTO2 cart) throws Exception;
	
	/* īƮ ���� */
	public int deleteCart(Long cartId);
	
	/* īƮ ���� ���� */
	public int modifyCount(CartDTO2 cart);
	
	/* īƮ ��� */
	public List<CartDTO2> getCartList(String memberId);	
	
	/* īƮ Ȯ�� */
	public CartDTO2 checkCart(CartDTO2 cart);		
	
	/* īƮ ����(�ֹ�) */
	public int deleteOrderCart(CartDTO2 dto);	
}
