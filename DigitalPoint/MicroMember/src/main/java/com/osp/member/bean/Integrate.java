package com.osp.member.bean;

import java.io.Serializable;

/**
 * 积分表
 * 
 * @author zhangmingcheng
 */
public class Integrate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String integrate;

	public Integrate() {
		super();
	}

	public String getIntegrate() {
		return integrate;
	}

	public void setIntegrate(String integrate) {
		this.integrate = integrate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
