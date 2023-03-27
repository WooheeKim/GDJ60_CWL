package com.team.cwl.members;

public interface AdminMapper {

	/* ��ǰ ��� */
	public void bookEnroll(BookVO book);
	
	/* ī�װ� ����Ʈ */
	public List<CateVO> cateList();	
	
	/* ��ǰ ����Ʈ */
	public List<BookVO> goodsGetList(Criteria cri);
	
	/* ��ǰ �� ���� */
	public int goodsGetTotal(Criteria cri);	
	
	/* ��ǰ ��ȸ ������ */
	public BookVO goodsGetDetail(int bookId);
	
	/* ��ǰ ���� */
	public int goodsModify(BookVO vo);	
	
	/* ��ǰ ���� ���� */
	public int goodsDelete(int bookId);	
	
	/* �̹��� ��� */
	public void imageEnroll(AttachImageVO vo);
	
	/* ���� ��ǰ �̹��� ��ü ���� */
	public void deleteImageAll(int bookId);
	
	/* ������ ��¥ �̹��� ����Ʈ */
	public List<AttachImageVO> checkFileList();
	
	/* ���� ��ǰ �̹��� ���� ��� */
	public List<AttachImageVO> getAttachInfo(int bookId);		
	
	/* �ֹ� ��ǰ ����Ʈ */
	public List<OrderDTO> getOrderList(Criteria cri);	
	
	/* �ֹ� �� ���� */
	public int getOrderTotal(Criteria cri);		
	
}
