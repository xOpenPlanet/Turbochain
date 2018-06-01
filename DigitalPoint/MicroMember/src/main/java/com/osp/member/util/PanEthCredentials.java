package com.osp.member.util;

import java.io.IOException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import com.osp.member.config.EtherConfig;

/**
 * 
 * @author fly
 *
 */
public class PanEthCredentials {

	private static String ip = EtherConfig.getIp();
	
	private static Credentials CredentialsN6;
	private static Credentials CredentialsN7;
	private static Credentials CredentialsN8;
	private static Credentials CredentialsFENG;
	
	public static Credentials getCredentialsN6() {
		if(CredentialsN6 == null) {
			synchronized(PanEthCredentials.class) {
				try {
					CredentialsN6 = WalletUtils.loadCredentials(EtherConfig.getCredentialsPwd(), 
							EtherConfig.getCredentialsPath());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (CipherException e) {
					e.printStackTrace();
				}
			}
		}
		
		return CredentialsN6;
	}
}
