package com.info.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.info.util.ResponseBodyWrapFactoryBean;

/**
 * 对response进行封装
 * @author v-dongdm
 *
 */
@Configuration
public class ResponseConfig {
	

	@Bean
    public ResponseBodyWrapFactoryBean getResponseBodyWrap() {
        return new ResponseBodyWrapFactoryBean();
    }

}
