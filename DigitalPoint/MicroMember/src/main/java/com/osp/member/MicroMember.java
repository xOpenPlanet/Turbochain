package com.osp.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 微会员
 * @author zhangmingcheng
 * @date 2018年5月23日
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
public class MicroMember extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MicroMember.class, args);
	}

}
