package com.osp.member.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.osp.member.bean.Integrate;
import com.osp.member.bean.IntegrateDetail;
import com.osp.member.dao.IntegrateDao;

/**
 * 积分数据库处理
 * 
 * @author zhangmingcheng
 */
@Repository
public class IntegrateDaoImpl implements IntegrateDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert_into_integrate(String id, BigInteger integrate) {
		String sql = "";
		if (this.existIntegrateData(id) == false) {
			sql = "insert into integrate(integrate,id) values(?,?)";
		} else {
			sql = "update integrate set integrate=? where id =?";
		}
		Object args[] = { integrate.toString(), id };
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public Boolean existIntegrateData(String id) {
		List<Integrate> integrateList = jdbcTemplate.query("select * from integrate where id=?;", new Object[] { id },
				new BeanPropertyRowMapper<Integrate>(Integrate.class));
		if (integrateList != null && integrateList.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int insert_into_integrate_detail(String txid, String memberOID, String companyOID, String siteOID,
			String createTime, String updateTime, BigInteger integral, String type, String deductibleAmount,
			String consumeAmount, String goods, String goodsQty) {
		String sql = "";
		if (this.existIntegrateDetailData(txid) == false) {
			sql = "insert into integrate_detail(memberOID, companyOID, siteOID, createTime, updateTime, integral,type, deductibleAmount, consumeAmount, goods, goodsQty,txid) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		} else {
			sql = "update integrate_detail set memberOID=?, companyOID=?, siteOID=?, createTime=?, updateTime=?, integral=?,type=?, deductibleAmount=?, consumeAmount=?, goods=?, goodsQty=? where txid =?";
		}
		Object args[] = {memberOID, companyOID, siteOID, createTime, updateTime, integral.toString(), type,
				deductibleAmount, consumeAmount, goods, goodsQty,txid};
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public Boolean existIntegrateDetailData(String txid) {
		List<IntegrateDetail> integrateDetail = jdbcTemplate.query("select * from integrate_detail where txid=?;",
				new Object[] { txid }, new BeanPropertyRowMapper<IntegrateDetail>(IntegrateDetail.class));
		if (integrateDetail != null && integrateDetail.size() > 0) {
			return true;
		}
		return false;
	}

}
