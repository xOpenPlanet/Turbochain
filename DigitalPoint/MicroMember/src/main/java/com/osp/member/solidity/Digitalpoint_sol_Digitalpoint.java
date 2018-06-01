package com.osp.member.solidity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class Digitalpoint_sol_Digitalpoint extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a033316600160a060020a0319909116179055610f358061003d6000396000f30060806040526004361061008d5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630124a14981146100925780633dc59c16146102ae5780636c7f1542146105545780638da5cb5b1461057e578063e3843db1146105af578063e82b0886146105ca578063f2fde38b146105e2578063f69ff64e14610605575b600080fd5b34801561009e57600080fd5b50604080516020601f60643560048181013592830184900484028501840190955281845261022b948035946024803595604435953695608494930191819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375094975061079e9650505050505050565b604051808315151515815260200180602001828103825283818151815260200191508051906020019080838360005b8381101561027257818101518382015260200161025a565b50505050905090810190601f16801561029f5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b3480156102ba57600080fd5b506102c66004356109e2565b6040805189815260208082018a905261010092820183815289519383019390935288519192916060840191608085019160a086019160c087019160e0880191610120890191908f019080838360005b8381101561032d578181015183820152602001610315565b50505050905090810190601f16801561035a5780820380516001836020036101000a031916815260200191505b5087810386528c5181528c516020918201918e019080838360005b8381101561038d578181015183820152602001610375565b50505050905090810190601f1680156103ba5780820380516001836020036101000a031916815260200191505b5087810385528b5181528b516020918201918d019080838360005b838110156103ed5781810151838201526020016103d5565b50505050905090810190601f16801561041a5780820380516001836020036101000a031916815260200191505b5087810384528a5181528a516020918201918c019080838360005b8381101561044d578181015183820152602001610435565b50505050905090810190601f16801561047a5780820380516001836020036101000a031916815260200191505b5087810383528951815289516020918201918b019080838360005b838110156104ad578181015183820152602001610495565b50505050905090810190601f1680156104da5780820380516001836020036101000a031916815260200191505b5087810382528851815288516020918201918a019080838360005b8381101561050d5781810151838201526020016104f5565b50505050905090810190601f16801561053a5780820380516001836020036101000a031916815260200191505b509e50505050505050505050505050505060405180910390f35b34801561056057600080fd5b5061056c600435610d5b565b60408051918252519081900360200190f35b34801561058a57600080fd5b50610593610d6d565b60408051600160a060020a039092168252519081900360200190f35b3480156105bb57600080fd5b5061056c600435602435610d7c565b3480156105d657600080fd5b5061056c600435610dac565b3480156105ee57600080fd5b50610603600160a060020a0360043516610dbe565b005b34801561061157600080fd5b50604080516020601f60643560048181013592830184900484028501840190955281845261022b948035946024803595604435953695608494930191819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a999881019791965091820194509250829150840183828082843750949750610e089650505050505050565b6000805460609033600160a060020a039081169116146107bd57600080fd5b6000898152600160205260409020548b11156107d857600080fd5b6000898152600160205260409020546107f7908c63ffffffff610e4616565b600160008b6000191660001916815260200190815260200160002081905550610100604051908101604052808b6000191681526020018a60001916815260200189815260200188815260200187815260200186815260200185815260200184815250600360008c60001916600019168152602001908152602001600020600082015181600001906000191690556020820151816001019060001916905560408201518160020190805190602001906108b0929190610e6e565b50606082015180516108cc916003840191602090910190610e6e565b50608082015180516108e8916004840191602090910190610e6e565b5060a08201518051610904916005840191602090910190610e6e565b5060c08201518051610920916006840191602090910190610e6e565b5060e0820151805161093c916007840191602090910190610e6e565b5050604080518c8152602081018c905281517fbec0f0a63d138d2b144ed4730f49d113e75a3a6a2df260d840bd9b0a0b0277b793509081900390910190a15050506000958652505060026020908152604080862080546001808201835591885296839020909601969096558551808701909652600786527f7375636365737300000000000000000000000000000000000000000000000000908601525091949293505050565b60036020908152600091825260409182902080546001808301546002808501805488519481161561010002600019011691909104601f810187900487028401870190975286835292959094919291830182828015610a815780601f10610a5657610100808354040283529160200191610a81565b820191906000526020600020905b815481529060010190602001808311610a6457829003601f168201915b5050505060038301805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152949594935090830182828015610b115780601f10610ae657610100808354040283529160200191610b11565b820191906000526020600020905b815481529060010190602001808311610af457829003601f168201915b5050505060048301805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152949594935090830182828015610ba15780601f10610b7657610100808354040283529160200191610ba1565b820191906000526020600020905b815481529060010190602001808311610b8457829003601f168201915b5050505060058301805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152949594935090830182828015610c315780601f10610c0657610100808354040283529160200191610c31565b820191906000526020600020905b815481529060010190602001808311610c1457829003601f168201915b5050505060068301805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152949594935090830182828015610cc15780601f10610c9657610100808354040283529160200191610cc1565b820191906000526020600020905b815481529060010190602001808311610ca457829003601f168201915b5050505060078301805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152949594935090830182828015610d515780601f10610d2657610100808354040283529160200191610d51565b820191906000526020600020905b815481529060010190602001808311610d3457829003601f168201915b5050505050905088565b60016020526000908152604090205481565b600054600160a060020a031681565b600260205281600052604060002081815481101515610d9757fe5b90600052602060002001600091509150505481565b60009081526002602052604090205490565b60005433600160a060020a03908116911614610dd957600080fd5b6000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b6000805460609033600160a060020a03908116911614610e2757600080fd5b6000898152600160205260409020546107f7908c63ffffffff610e5816565b600082821115610e5257fe5b50900390565b600082820183811015610e6757fe5b9392505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610eaf57805160ff1916838001178555610edc565b82800160010185558215610edc579182015b82811115610edc578251825591602001919060010190610ec1565b50610ee8929150610eec565b5090565b610f0691905b80821115610ee85760008155600101610ef2565b905600a165627a7a72305820a44b6f15533e4b676d9d352950d7d9db11166c0d9bdd6fbab7ea36361e0d7a4d0029";

    protected Digitalpoint_sol_Digitalpoint(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Digitalpoint_sol_Digitalpoint(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<InstructorEventResponse> getInstructorEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Instructor", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<InstructorEventResponse> responses = new ArrayList<InstructorEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InstructorEventResponse typedResponse = new InstructorEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.txid = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.memberOID = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<InstructorEventResponse> instructorEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Instructor", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, InstructorEventResponse>() {
            @Override
            public InstructorEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                InstructorEventResponse typedResponse = new InstructorEventResponse();
                typedResponse.log = log;
                typedResponse.txid = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.memberOID = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> deductJiFen_flow(BigInteger value, byte[] txid, byte[] memberOID, String companyOID, String siteOID, String createTime, String updateTime, String integral, String types_deductibleAmount_consumeAmount_goods_goodsQty) {
        final Function function = new Function(
                "deductJiFen_flow", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.generated.Bytes32(txid), 
                new org.web3j.abi.datatypes.generated.Bytes32(memberOID), 
                new org.web3j.abi.datatypes.Utf8String(companyOID), 
                new org.web3j.abi.datatypes.Utf8String(siteOID), 
                new org.web3j.abi.datatypes.Utf8String(createTime), 
                new org.web3j.abi.datatypes.Utf8String(updateTime), 
                new org.web3j.abi.datatypes.Utf8String(integral), 
                new org.web3j.abi.datatypes.Utf8String(types_deductibleAmount_consumeAmount_goods_goodsQty)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple8<byte[], byte[], String, String, String, String, String, String>> tx_details(byte[] param0) {
        final Function function = new Function("tx_details", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple8<byte[], byte[], String, String, String, String, String, String>>(
                new Callable<Tuple8<byte[], byte[], String, String, String, String, String, String>>() {
                    @Override
                    public Tuple8<byte[], byte[], String, String, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<byte[], byte[], String, String, String, String, String, String>(
                                (byte[]) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> balanceOf(byte[] param0) {
        final Function function = new Function("balanceOf", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<byte[]> user_txs(byte[] param0, BigInteger param1) {
        final Function function = new Function("user_txs", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> getUser_txsLength(byte[] memberOID) {
        final Function function = new Function("getUser_txsLength", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(memberOID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> distributeJiFen_flow(BigInteger value, byte[] txid, byte[] memberOID, String companyOID, String siteOID, String createTime, String updateTime, String integral, String types_deductibleAmount_consumeAmount_goods_goodsQty) {
        final Function function = new Function(
                "distributeJiFen_flow", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.generated.Bytes32(txid), 
                new org.web3j.abi.datatypes.generated.Bytes32(memberOID), 
                new org.web3j.abi.datatypes.Utf8String(companyOID), 
                new org.web3j.abi.datatypes.Utf8String(siteOID), 
                new org.web3j.abi.datatypes.Utf8String(createTime), 
                new org.web3j.abi.datatypes.Utf8String(updateTime), 
                new org.web3j.abi.datatypes.Utf8String(integral), 
                new org.web3j.abi.datatypes.Utf8String(types_deductibleAmount_consumeAmount_goods_goodsQty)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Digitalpoint_sol_Digitalpoint> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Digitalpoint_sol_Digitalpoint.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Digitalpoint_sol_Digitalpoint> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Digitalpoint_sol_Digitalpoint.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Digitalpoint_sol_Digitalpoint load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Digitalpoint_sol_Digitalpoint(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Digitalpoint_sol_Digitalpoint load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Digitalpoint_sol_Digitalpoint(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class InstructorEventResponse {
        public Log log;

        public byte[] txid;

        public byte[] memberOID;
    }
}
