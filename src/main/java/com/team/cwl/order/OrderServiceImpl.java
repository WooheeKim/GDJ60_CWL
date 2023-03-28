package com.team.cwl.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.cwl.cart.CartDTO;
import com.team.cwl.cart.CartMapper;
import com.team.cwl.member.MemberDTO;
import com.team.cwl.member.MemberMapper;
import com.team.cwl.product.ProductDTO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private CartMapper cartMapper;

//	@Autowired
//	private ProductMapper productMapper;
	
	@Override
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders) {
		
		List<OrderPageItemDTO> result = new ArrayList<OrderPageItemDTO>();
		
		for(OrderPageItemDTO ord : orders) {
			OrderPageItemDTO goodsInfo = orderMapper.getGoodsInfo(ord.getProductNum());
			goodsInfo.setOrderCount(ord.getOrderCount());
			
			goodsInfo.initTotal();
			
			result.add(goodsInfo);
		}
		return result;
	}
	
	@Override
	@Transactional
	public void order(OrderDTO ord) {
		// ����� ������ ��������
		// ȸ������
		MemberDTO member = memberMapper.getMemberInfo(ord.getMemberId());
		// �ֹ�����
		List<OrderItemDTO> ords = new ArrayList<>();
		for(OrderItemDTO oit : ord.getOrders()) {
			OrderItemDTO orderItem = orderMapper.getOrderInfo(oit.getProductNum());
			// ���� ����
			orderItem.setOrderCount(oit.getOrderCount());
			// �⺻���� ����
			orderItem.initTotal();
			// List ��ü �߰�
			ords.add(orderItem);
		}
		// OrderDTO ����
		ord.setOrders(ords);
		ord.getOrderPriceInfo();
		
		/* DB �ֹ�, �ֹ���ǰ(�������) �ֱ� */
		// orderNum ����� �� OrderDTO��ü orderNum�� ����
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("_yyyyMMddmm");
		String orderNum = member.getMemberId() + format.format(date);
		ord.setOrderNum(orderNum);
		
		// DB�ֱ�
		orderMapper.enrollOrder(ord);
		for(OrderItemDTO oit : ord.getOrders()) {
			oit.setOrderNum(orderNum);
			orderMapper.enrollOrderItem(oit);
		}
		
		/* ��� ���� ���� */
		Long calMoney = member.getMoney();
		calMoney -= ord.getOrderFinalSalePrice();
		member.setMoney(calMoney);
		
		orderMapper.deductMoney(member);
		
		/* ��� ���� ���� */
//		for(OrderItemDTO oit : ord.getOrders()) {
//			// ���� ��� �� ���ϱ�
//			ProductDTO productDTO = ProductMapper.getGoodsInfo(oit.getProductNum());
//			productDTO.setProductStock(productDTO.getProductStock() - oit.getOrderCount());
//			// ���� �� DB ����
//			orderMapper.deductStock(productDTO);
//		}
		
		// ��ٱ��� ����
		for(OrderItemDTO oit : ord.getOrders()) {
			CartDTO dto = new CartDTO();
			dto.setMemberId(ord.getMemberId());
			dto.setProductNum(oit.getProductNum());
			
			cartMapper.deleteOrderCart(dto);			
		}
		
	}
	
	/* �ֹ���� */
	@Override
	@Transactional
	public void orderCancel(OrderCancelDTO dto) {
		/* �ֹ�, �ֹ���ǰ ��ü */
		// ȸ��
		MemberDTO member = memberMapper.getMemberInfo(dto.getMemberId());
		// �ֹ���ǰ
		List<OrderItemDTO> ords = orderMapper.getOrderItemInfo(dto.getOrderNum());
		for(OrderItemDTO ord : ords) {
			ord.initTotal();
		}
		// �ֹ�
		OrderDTO orw = orderMapper.getOrder(dto.getOrderNum());
		orw.setOrders(ords);
		
		orw.getOrderPriceInfo();
		
		/* �ֹ���ǰ ��� DB */
		orderMapper.orderCancel(dto.getOrderNum());
		/* ��, ��� ��ȯ */
		// ��
		Long calMoney = member.getMoney();
		calMoney += orw.getOrderFinalSalePrice();
		member.setMoney(calMoney);
		// DB ����
		orderMapper.deductMoney(member);
		// ���
		for(OrderItemDTO ord : orw.getOrders()) {
			ProductDTO productDTO = productMapper.getGoodsInfo(ord.getProductNum());
			productDTO.setProductStock(productDTO.getProductStock() + ord.getOrderCount());
			orderMapper.deductStock(productDTO);
		}
		
	}
	
}
