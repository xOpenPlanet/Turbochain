package com.osp.member.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osp.common.json.JsonUtil;
import com.osp.member.bean.IntegrateDetail;
import com.osp.member.model.ResponseObject;
import com.osp.member.service.IntegrateService;

/**
 * 积分智能合约
 * 
 * @author fly
 *
 */
@Controller
public class IntegrateController {

	@Autowired
	private IntegrateService integrateService;

	/**
	 * 分发积分
	 * 
	 * @param txid
	 *            积分详情编号(对应积分详情表OID)
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
	@RequestMapping(value = "/distributeIntegrate", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String distributeIntegrate(@RequestBody IntegrateDetail integrateDetail) {
		ResponseObject ro = ResponseObject.getInstance();
		integrateService.distributIntegrate(integrateDetail.getTxid(), integrateDetail.getMemberOID(),
				integrateDetail.getCompanyOID(), integrateDetail.getSiteOID(), integrateDetail.getCreateTime(),
				integrateDetail.getUpdateTime(), new BigInteger(integrateDetail.getIntegral()),
				integrateDetail.getType(), integrateDetail.getDeductibleAmount(), integrateDetail.getConsumeAmount(),
				integrateDetail.getGoods(), integrateDetail.getGoodsQty(), ro);
		return JsonUtil.beanToJson(ro);
	}

	/**
	 * 根据memberOID查询积分
	 * 
	 * @param memberOID
	 * @return
	 */
	@RequestMapping(value = "/queryIntegrate", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String queryIntegrate(@RequestParam(value = "memberOID", defaultValue = "") String memberOID) {
		ResponseObject ro = ResponseObject.getInstance();
		BigInteger integrate = integrateService.queryIntegrate(memberOID, ro);
		ro.setMessage(integrate.toString());
		return JsonUtil.beanToJson(ro);
	}

	/**
	 * 根据memberOID查询用户积分明细
	 * 
	 * @param memberOID
	 * @return
	 */
	@RequestMapping(value = "/queryIntegrateDetail", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String queryIntegrateDetail(@RequestParam(value = "memberOID", defaultValue = "") String memberOID) {
		ResponseObject ro = ResponseObject.getInstance();
		integrateService.queryIntegrateDetail(memberOID, ro);
		return JsonUtil.beanToJson(ro);
	}

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
	 * @return
	 */
	@RequestMapping(value = "/deductIntegrate", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String deductIntegrate(@RequestBody IntegrateDetail integrateDetail) {
		ResponseObject ro = ResponseObject.getInstance();
		integrateService.deductIntegrate(integrateDetail.getTxid(), integrateDetail.getMemberOID(),
				integrateDetail.getCompanyOID(), integrateDetail.getSiteOID(), integrateDetail.getCreateTime(),
				integrateDetail.getUpdateTime(), new BigInteger(integrateDetail.getIntegral()),
				integrateDetail.getType(), integrateDetail.getDeductibleAmount(), integrateDetail.getConsumeAmount(),
				integrateDetail.getGoods(), integrateDetail.getGoodsQty(), ro);
		return JsonUtil.beanToJson(ro);
	}
}
