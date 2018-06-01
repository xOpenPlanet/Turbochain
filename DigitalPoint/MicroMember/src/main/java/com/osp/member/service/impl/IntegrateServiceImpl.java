package com.osp.member.service.impl;

import static org.web3j.tx.Contract.GAS_LIMIT;
import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;

import com.osp.member.bean.IntegrateDetail;
import com.osp.member.config.EtherConfig;
import com.osp.member.dao.IntegrateDao;
import com.osp.member.model.ResponseObject;
import com.osp.member.service.IntegrateService;
import com.osp.member.solidity.Digitalpoint_sol_Digitalpoint;
import com.osp.member.util.BaseUtil;
import com.osp.member.util.PanEthCredentials;
import com.osp.member.util.Web3JClient;

@Service
public class IntegrateServiceImpl implements IntegrateService {

	@Autowired
	private IntegrateDao integrateDaoImpl;

	private Digitalpoint_sol_Digitalpoint contract = Digitalpoint_sol_Digitalpoint.load(EtherConfig.getContractAddress(), Web3JClient.getClient(),
			PanEthCredentials.getCredentialsN6(), GAS_PRICE, GAS_LIMIT);

	/**
	 * 1、调用合约扣除积分
	 * 
	 * 2、调用合约存储积分明细
	 * 
	 * 3、调用合约维护用户与积分明细关系
	 * 
	 * 4、维护积分信息到integrate表（先调用合约查询用户积分，预防通过geth客户端等其他方式调用合约导致用户积分信息与数据库维护的信息不一致）
	 * 
	 * 5、维护积分明细到integrate_detail表
	 */
	@Transactional
	@Override
	public void distributIntegrate(String txid, String memberOID, String companyOID, String siteOID, String createTime,
			String updateTime, BigInteger integral, String type, String deductibleAmount, String consumeAmount,
			String goods, String goodsQty, ResponseObject ro) {
		try {
			BigInteger userIntegrate = this.queryIntegrate(memberOID, ro);
			String types_deductibleAmount_consumeAmount_goods_goodsQty = BaseUtil.orgaIntegrateDetailValue(type,
					deductibleAmount, consumeAmount, goods, goodsQty);
			RemoteCall<TransactionReceipt> remoteCall = contract.distributeJiFen_flow(integral, txid.getBytes("UTF-8"),
					memberOID.getBytes("UTF-8"), companyOID, siteOID, createTime, updateTime, integral.toString(),
					types_deductibleAmount_consumeAmount_goods_goodsQty);
			TransactionReceipt transactionReceipt = remoteCall.send();
			ro.setMessage("TxnHash:" + transactionReceipt.getTransactionHash());

			integrateDaoImpl.insert_into_integrate(memberOID, integral.add(userIntegrate));
			integrateDaoImpl.insert_into_integrate_detail(txid, memberOID, companyOID, siteOID, createTime, updateTime,
					integral, type, deductibleAmount, consumeAmount, goods, goodsQty);
		} catch (Exception e) {
			ro.setMessage("调用合约失败!");
			ro.setStatus(500);
			e.printStackTrace();
		}
		return;
	}

	/**
	 * 1、调用合约扣除积分
	 * 
	 * 2、调用合约存储积分明细
	 * 
	 * 3、调用合约维护用户与积分明细关系
	 * 
	 * 4、维护积分表
	 * 
	 * 5、维护积分明细到integrate_detail表
	 */
	@Transactional
	@Override
	public void deductIntegrate(String txid, String memberOID, String companyOID, String siteOID, String createTime,
			String updateTime, BigInteger integral, String type, String deductibleAmount, String consumeAmount,
			String goods, String goodsQty, ResponseObject ro) {
		try {
			BigInteger userIntegrate = this.queryIntegrate(memberOID, ro);
			if (userIntegrate.compareTo(integral) < 0) {
				ro.setMessage("Your balance is not enough!");
				return;
			}
			String types_deductibleAmount_consumeAmount_goods_goodsQty = BaseUtil.orgaIntegrateDetailValue(type,
					deductibleAmount, consumeAmount, goods, goodsQty);
			RemoteCall<TransactionReceipt> remoteCall = contract.deductJiFen_flow(integral, txid.getBytes("UTF-8"),
					memberOID.getBytes("UTF-8"), companyOID, siteOID, createTime, updateTime, integral.toString(),
					types_deductibleAmount_consumeAmount_goods_goodsQty);
			TransactionReceipt transactionReceipt = remoteCall.send();
			ro.setMessage("TxnHash:" + transactionReceipt.getTransactionHash());

			integrateDaoImpl.insert_into_integrate(memberOID, userIntegrate.subtract(integral));
			integrateDaoImpl.insert_into_integrate_detail(txid, memberOID, companyOID, siteOID, createTime, updateTime,
					integral, type, deductibleAmount, consumeAmount, goods, goodsQty);
		} catch (Exception e) {
			ro.setMessage("调用合约失败!");
			ro.setStatus(500);
			e.printStackTrace();
		}
		return;
	}


	/**
	 * 查询用户积分明细列表
	 * 
	 * @param uuid
	 * @param ro
	 * @return
	 */
	@Override
	public List<IntegrateDetail> queryIntegrateDetail(String uuid, ResponseObject ro) {
		Set<String> integrateDetailBeans = new HashSet<>();
		List<IntegrateDetail> integrateDetailLists = new ArrayList<>();
		ro.setStatus(200);
		try {
			BigInteger length = contract.getUser_txsLength(uuid.getBytes("UTF-8")).send();
			for (BigInteger i = new BigInteger("0"); i.compareTo(length) < 0; i = i.add(new BigInteger("1"))) {
				String txid = new String(contract.user_txs(uuid.getBytes("UTF-8"), i).send());
				integrateDetailBeans.add(txid);
			}
			for (String txid : integrateDetailBeans) {
				Tuple8<byte[], byte[], String, String, String, String, String, String> tuple8 = contract
						.tx_details(txid.getBytes("UTF-8")).send();
				IntegrateDetail integrateDetail = BaseUtil.orgaIntegrateDetail(tuple8);
				integrateDetailLists.add(integrateDetail);
			}
			ro.setValue("data", integrateDetailLists);
		} catch (Exception e) {
			ro.setStatus(500);
			e.printStackTrace();
		}
		return integrateDetailLists;
	}

	/**
	 * 查询用户积分
	 * 
	 * @param memberOID
	 * @return
	 */
	@Override
	public BigInteger queryIntegrate(String memberOID, ResponseObject ro) {
		BigInteger integrate = new BigInteger("0");
		ro.setStatus(200);
		try {
			integrate = contract.balanceOf(memberOID.getBytes("UTF-8")).send();
		} catch (Exception e) {
			ro.setStatus(500);
			e.printStackTrace();
		}
		return integrate;
	}

}
