pragma solidity ^0.4.22;

/**
 * @title SafeMath
 * @dev Math operations with safety checks that throw on error
 */
library SafeMath {
  function mul(uint256 a, uint256 b) internal constant returns (uint256) {
    uint256 c = a * b;
    assert(a == 0 || c / a == b);
    return c;
  }

  function div(uint256 a, uint256 b) internal constant returns (uint256) {
    // assert(b > 0); // Solidity automatically throws when dividing by 0
    uint256 c = a / b;
    // assert(a == b * c + a % b); // There is no case in which this doesn't hold
    return c;
  }

  function sub(uint256 a, uint256 b) internal constant returns (uint256) {
    assert(b <= a);
    return a - b;
  }

  function add(uint256 a, uint256 b) internal constant returns (uint256) {
    uint256 c = a + b;
    assert(c >= a);
    return c;
  }
}

contract owned {
    address public owner;

    function owned() public {
        owner = msg.sender;
    }

    modifier onlyOwner {
        require(msg.sender == owner);
        _;
    }

    function transferOwnership(address newOwner) onlyOwner public {
        owner = newOwner;
    }
}

contract Digitalpoint is owned {

   using SafeMath for uint256;

   function Digitalpoint() public {}

   event Instructor(bytes32 txid, bytes32 memberOID);

   struct TxDetail{
      bytes32 txid;
      bytes32 memberOID;
      string companyOID;
      string siteOID;
      string createTime;
      string updateTime;
      string integral;
      string types_deductibleAmount_consumeAmount_goods_goodsQty;
   }

	mapping(bytes32 => uint256) public balanceOf;
	mapping(bytes32 => bytes32[]) public user_txs;
	mapping(bytes32 => TxDetail) public tx_details;

	function distributeJiFen_flow(uint256 value, bytes32 txid, bytes32 memberOID, string companyOID, string siteOID, string createTime, string updateTime, string integral, string types_deductibleAmount_consumeAmount_goods_goodsQty) onlyOwner public returns (bool, string){
	   balanceOf[memberOID] = balanceOf[memberOID].add(value);

	   tx_details[txid] = TxDetail(txid,memberOID,companyOID,siteOID,createTime,updateTime,integral,types_deductibleAmount_consumeAmount_goods_goodsQty);
       emit Instructor(txid, memberOID);

	   user_txs[memberOID].push(txid);
	   return (true,"success");
	}

	function deductJiFen_flow(uint256 value, bytes32 txid, bytes32 memberOID, string companyOID, string siteOID, string createTime, string updateTime, string integral, string types_deductibleAmount_consumeAmount_goods_goodsQty) onlyOwner public returns (bool, string){
	   require(balanceOf[memberOID] >= value);                // Check if the targeted balance is enough
       balanceOf[memberOID] = balanceOf[memberOID].sub(value);                        // Subtract from the targeted balance

	   tx_details[txid] = TxDetail(txid, memberOID, companyOID, siteOID, createTime, updateTime, integral, types_deductibleAmount_consumeAmount_goods_goodsQty);
       emit Instructor(txid, memberOID);

	   user_txs[memberOID].push(txid);
	   return (true, "success");
	}

    function getUser_txsLength(bytes32 memberOID) public constant returns (uint256) {
        return user_txs[memberOID].length;
    }

}