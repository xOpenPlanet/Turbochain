package com.osp.member.service;

import java.math.BigInteger;
import java.util.List;

import com.osp.member.bean.IntegrateDetail;
import com.osp.member.model.ResponseObject;

public interface IntegrateService {

	/**
	 * 分发积分
	 * 
	 * @param txid
	 * @param memberOID
	 * @param companyOID
	 * @param siteOID
	 * @param createTime
	 * @param updateTime
	 * @param integral
	 * @param type
	 * @param deductibleAmount
	 * @param consumeAmount
	 * @param goods
	 * @param goodsQty
	 * @param ro
	 */
	void distributIntegrate(String txid, String memberOID, String companyOID, String siteOID, String createTime,
			String updateTime, BigInteger integral, String type, String deductibleAmount, String consumeAmount,
			String goods, String goodsQty, ResponseObject ro);

	/**
	 * 扣除积分
	 * 
	 * @param txid
	 * @param memberOID
	 * @param companyOID
	 * @param siteOID
	 * @param createTime
	 * @param updateTime
	 * @param integral
	 * @param type
	 * @param deductibleAmount
	 * @param consumeAmount
	 * @param goods
	 * @param goodsQty
	 * @param ro
	 */
	void deductIntegrate(String txid, String memberOID, String companyOID, String siteOID, String createTime,
			String updateTime, BigInteger integral, String type, String deductibleAmount, String consumeAmount,
			String goods, String goodsQty, ResponseObject ro);

	/**
	 * 查询积分
	 * 
	 * @param uuid
	 * @param ro
	 * @return
	 */
	BigInteger queryIntegrate(String uuid, ResponseObject ro);

	/**
	 * 查询用户积分明细
	 * 
	 * @param uuid
	 * @param ro
	 * @return
	 */
	List<IntegrateDetail> queryIntegrateDetail(String uuid, ResponseObject ro);
}
