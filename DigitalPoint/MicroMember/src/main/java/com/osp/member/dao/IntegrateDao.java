package com.osp.member.dao;

import java.math.BigInteger;

/**
 * 积分数据库操作接口
 * 
 * @author zhangmingcheng
 */
public interface IntegrateDao {

	/**
	 * 维护积分信息到积分表
	 * 
	 * @param id
	 *            用户编号
	 * @param integrate
	 *            积分
	 * @return
	 */
	int insert_into_integrate(String id, BigInteger integrate);

	/**
	 * 判断积分表是否存在用户编号为id的记录
	 * 
	 * @param id
	 * @return
	 */
	Boolean existIntegrateData(String id);

	/**
	 * 维护积分明细表
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
	 * @return
	 */
	int insert_into_integrate_detail(String txid, String memberOID, String companyOID, String siteOID, String createTime,
			String updateTime, BigInteger integral, String type, String deductibleAmount, String consumeAmount,
			String goods, String goodsQty);
	
	/**
	 * 判断积分明细表是否存在编号为txid的记录
	 * 
	 * @param txid
	 * @return
	 */
	Boolean existIntegrateDetailData(String txid);
}
