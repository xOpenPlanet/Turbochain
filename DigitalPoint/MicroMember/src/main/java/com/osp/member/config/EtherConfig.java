package com.osp.member.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *  以太坊配置文件
 * @author zhangmingcheng
 * @date 2018年5月23日
 */
@Configuration
@PropertySource("classpath:ethstore.properties")
public class EtherConfig {

	private static String ip;
	
	/**
	 * keystore位置
	 */
	private static String credentialsPath;

	/**
	 * keystore密码
	 */
	private static String credentialsPwd;
	
	/**
	 * 合约地址
	 */
	private static String contractAddress;
	

	@Value("${web3j.client.ip}")
	private String web3jClientIp;
	
	@Value("${Credentials.path}")
	private String path;
	
	@Value("${Credentials.pwd}")
	private String credentialsPwdPath;

	@Value("${contractAddress}")
	private String contractAddressConf;
	
	@PostConstruct
	public void init() {
		EtherConfig.ip = this.web3jClientIp;
		EtherConfig.credentialsPath = this.path;
		credentialsPwd = readToString(credentialsPwdPath);
		EtherConfig.contractAddress = this.contractAddressConf;
	}
	
	
	public static String getIp() {
		return ip;
	}

	public static void setIp(String ip) {
		EtherConfig.ip = ip;
	}

	public String getWeb3jClientIp() {
		return web3jClientIp;
	}

	public void setWeb3jClientIp(String web3jClientIp) {
		this.web3jClientIp = web3jClientIp;
	}
	
	
	
	public static String getCredentialsPath() {
		return credentialsPath;
	}


	public static void setCredentialsPath(String credentialsPath) {
		EtherConfig.credentialsPath = credentialsPath;
	}


	public static String getCredentialsPwd() {
		return credentialsPwd;
	}


	public static void setCredentialsPwd(String credentialsPwd) {
		EtherConfig.credentialsPwd = credentialsPwd;
	}


	public static String getContractAddress() {
		return contractAddress;
	}


	public static void setContractAddress(String contractAddress) {
		EtherConfig.contractAddress = contractAddress;
	}


	public static String readToString(String fileName) {  
        String encoding = "UTF-8";  
        File file = new File(fileName);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
            System.err.println("The OS does not support " + encoding);  
            e.printStackTrace();  
            return null;  
        }  
    }
}
