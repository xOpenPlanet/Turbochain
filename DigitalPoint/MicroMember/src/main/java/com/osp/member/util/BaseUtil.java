package com.osp.member.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.web3j.tuples.generated.Tuple8;

import com.osp.member.bean.IntegrateDetail;

/**
 * 积分市场工具类
 * 
 * @author zhangmingcheng
 */
public class BaseUtil {

	/**
	 * 获取当前时间:格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		return sdf.format(date);
	}

	/**
	 * 组织积分明细types_deductibleAmount_consumeAmount_goods_goodsQty属性的值
	 * 
	 * @param type
	 * @param deductibleAmount
	 * @param consumeAmount
	 * @param goods
	 * @param goodsQty
	 * @return
	 */
	public static String orgaIntegrateDetailValue(String type, String deductibleAmount, String consumeAmount,
			String goods, String goodsQty) {
		String types_deductibleAmount_consumeAmount_goods_goodsQty = type + ";" + deductibleAmount + ";" + consumeAmount
				+ ";" + goods + ";" + goodsQty;
		return types_deductibleAmount_consumeAmount_goods_goodsQty;
	}

	/**
	 * 组织IntegrateDetail
	 * 
	 * @param tuple8
	 * @return
	 */
	public static IntegrateDetail orgaIntegrateDetail(
			Tuple8<byte[], byte[], String, String, String, String, String, String> tuple8) throws Exception {
		IntegrateDetail integrateDetail = new IntegrateDetail();
		integrateDetail.setTxid(new String(tuple8.getValue1()));
		integrateDetail.setMemberOID(new String(tuple8.getValue2()));
		integrateDetail.setCompanyOID(tuple8.getValue3());
		integrateDetail.setSiteOID(tuple8.getValue4());
		integrateDetail.setCreateTime(tuple8.getValue5());
		integrateDetail.setUpdateTime(tuple8.getValue6());
		integrateDetail.setIntegral(tuple8.getValue7());
		String types_deductibleAmount_consumeAmount_goods_goodsQty = tuple8.getValue8();
		String[] temp = types_deductibleAmount_consumeAmount_goods_goodsQty.split(";");
		integrateDetail.setType(temp[0]);
		integrateDetail.setDeductibleAmount(temp[1]);
		integrateDetail.setConsumeAmount(temp[2]);
		integrateDetail.setGoods(temp[3]);
		integrateDetail.setGoodsQty(temp[4]);
		return integrateDetail;
	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(Long lt) {
		String res;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(lt * 1000L);
		res = sdf.format(date);
		return res;
	}

	/**
	 * 大整数16进制转10进制
	 * 
	 * @param hex
	 * @return
	 */
	public static String hexTransformToDec(String hex) {
		BigInteger base = new BigInteger("16");
		BigDecimal result = new BigDecimal("0.00000000");
		try {
			hex = hex.substring(2);
			for (int i = 0; i < hex.length(); i++) {
				char ch = hex.charAt(hex.length() - 1 - i);
				if (ch >= 'a' && ch <= 'f') {
					BigInteger tmp = base.pow(i).multiply(new BigInteger(Integer.toString((ch - 'a' + 10))));
					result = result.add(new BigDecimal(tmp));
				} else if (ch >= 'A' && ch <= 'F') {
					BigInteger tmp = base.pow(i).multiply(new BigInteger(Integer.toString((ch - 'A' + 10))));
					result = result.add(new BigDecimal(tmp));
				} else {
					BigInteger tmp = base.pow(i).multiply(new BigInteger(Character.toString(ch)));
					result = result.add(new BigDecimal(tmp));
				}
			}
			result = result.divide(new BigDecimal("10").pow(18));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}
