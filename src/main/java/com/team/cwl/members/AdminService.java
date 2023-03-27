package com.team.cwl.members;

import com.team.cwl.product.ProductDTO;

public interface AdminService {
	
	/* ��ǰ ��� */
	public void bookEnroll(BookVO book);	
	
	/* ī�װ� ����Ʈ */
	public List<CateVO> cateList();
	
	/* ��ǰ ����Ʈ */
	public List<BookVO> goodsGetList(Criteria cri);
	
	/* ��ǰ �� ���� */
	public int goodsGetTotal(Criteria cri);		
	
	/* ��ǰ ��ȸ ������ */
	public ProductDTO goodsGetDetail(int bookId);	
	
	/* ��ǰ ���� */
	public int goodsModify(BookVO vo);	
	
	/* ��ǰ ���� ���� */
	public int goodsDelete(int bookId);	
	
	/* ���� ��ǰ �̹��� ���� ��� */
	public List<AttachImageVO> getAttachInfo(int bookId);		
	
	/* �ֹ� ��ǰ ����Ʈ */
	public List<OrderDTO> getOrderList(Criteria cri);
	
	/* �ֹ� �� ���� */
	public int getOrderTotal(Criteria cri);		
}
