package com.team.cwl.cart;

import java.util.List;


public interface CartDAO {
	List<CartDTO> cartA();
	void insert(CartDTO cartDTO); // ��ٱ��� �߰�
	List<CartDTO> cartList(String memberId); // ��ٱ��� ���
	void delete(Long cartNum); // ��ٱ��� ���� ����
	void deleteAll(String memberId); // ��ٱ��� ����
	void update (Long cartNum);
	int sumMoney(String memberId); // ��ٱ��� �ݾ� �հ�
	int carCount(String memberId, Long productNum); // ��ٱ��� ��ǰ ����
	void updateCart(CartDTO cartDTO); // ��ٱ��� ����
	void modifyCart(CartDTO cartDTO);
	
}
