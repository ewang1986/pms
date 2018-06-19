package com.info.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class MD5utilTest {
	
	/**
	 * HD5编码
	 */
	@Test
	public void md5Hex() {
		System.out.println(DigestUtils.md5Hex("123456"));
	}

}
