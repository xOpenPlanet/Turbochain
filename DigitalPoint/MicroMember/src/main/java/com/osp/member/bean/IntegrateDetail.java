package com.osp.member.bean;

import java.io.Serializable;

/**
 * 积分明细表
 * 
 * @author zhangmingcheng
 * @date 2018年5月25日
 */
public class IntegrateDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String txid;
	private String memberOID;
	private String companyOID;
	private String siteOID;
	private String createTime;
	private String updateTime;
	private String integral;
	private String type;
	private String deductibleAmount;
	private String consumeAmount;
	private String goods;
	private String goodsQty;

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public String getMemberOID() {
		return memberOID;
	}

	public void setMemberOID(String memberOID) {
		this.memberOID = memberOID;
	}

	public String getCompanyOID() {
		return companyOID;
	}

	public void setCompanyOID(String companyOID) {
		this.companyOID = companyOID;
	}

	public String getSiteOID() {
		return siteOID;
	}

	public void setSiteOID(String siteOID) {
		this.siteOID = siteOID;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeductibleAmount() {
		return deductibleAmount;
	}

	public void setDeductibleAmount(String deductibleAmount) {
		this.deductibleAmount = deductibleAmount;
	}

	public String getConsumeAmount() {
		return consumeAmount;
	}

	public void setConsumeAmount(String consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getGoodsQty() {
		return goodsQty;
	}

	public void setGoodsQty(String goodsQty) {
		this.goodsQty = goodsQty;
	}
}
