package com.team.cwl.members;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AdminServiceImpl implements AdminService {
	
	private AdminMapper adminMapper;
	
	/* ��ǰ ��� */
	@Transactional
	@Override
	public void bookEnroll(BookVO book) {
		
		log.info("(srevice)bookEnroll........");
		
		adminMapper.bookEnroll(book);
		
		if(book.getImageList() == null || book.getImageList().size() <= 0) {
			return;
		}
		
		book.getImageList().forEach(attach ->{
			
			attach.setBookId(book.getBookId());
			adminMapper.imageEnroll(attach);
			
		});
		
		
	}

	/* ī�װ� ����Ʈ */
	@Override
	public List<CateVO> cateList() {
		
		log.info("(service)cateList........");
		
		return adminMapper.cateList();
	}

	/* ��ǰ ����Ʈ */
	@Override
	public List<BookVO> goodsGetList(Criteria cri) {
		
		log.info("goodsGetTotalList()..........");
		
		return adminMapper.goodsGetList(cri);
	}

	/* ��ǰ �� ���� */
	public int goodsGetTotal(Criteria cri) {
		
		log.info("goodsGetTotal().........");
		
		return adminMapper.goodsGetTotal(cri);
	}	
	
	/* ��ǰ ��ȸ ������ */
	@Override
	public BookVO goodsGetDetail(int bookId) {
		
		log.info("(service)bookGetDetail......." + bookId);
		
		return adminMapper.goodsGetDetail(bookId);
	}	
	
	/* ��ǰ ���� ���� */
	@Transactional
	@Override
	public int goodsModify(BookVO vo) {

		int result = adminMapper.goodsModify(vo);
		
		if(result == 1 && vo.getImageList() != null && vo.getImageList().size() > 0) {
			
			adminMapper.deleteImageAll(vo.getBookId());
			
			vo.getImageList().forEach(attach -> {
				
				attach.setBookId(vo.getBookId());
				adminMapper.imageEnroll(attach);
				
			});
			
		}
		
		return result;
	}	
	
	
	/* ��ǰ ���� ���� */
	@Override
	@Transactional
	public int goodsDelete(int bookId) {

		log.info("goodsDelete..........");
		
		adminMapper.deleteImageAll(bookId);			
		
		return adminMapper.goodsDelete(bookId);
	}		
	
	
	/* ���� ��ǰ �̹��� ���� ��� */
	@Override
	public List<AttachImageVO> getAttachInfo(int bookId) {
		
		log.info("getAttachInfo........");
		
		return adminMapper.getAttachInfo(bookId);
	}
	
	/* �ֹ� ��ǰ ����Ʈ */
	@Override
	public List<OrderDTO> getOrderList(Criteria cri) {
		return adminMapper.getOrderList(cri);
	}
	
	/* �ֹ� �� ���� */
	@Override
	public int getOrderTotal(Criteria cri) {
		return adminMapper.getOrderTotal(cri);
	}		
	 
	
}
