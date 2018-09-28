package com.task.domain;


import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * @author Robin
 *
 */
public class MD5Util {

	/**
	 * 将密码用MD5加密
	 * 
	 * @param rawPass
	 *            密码明文
	 * @param salt
	 *            密钥
	 * @return 返加密码明文的MD5摘要
	 */
	public final static String encode(String rawPass, String salt) {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		md5.setEncodeHashAsBase64(false);

		return md5.encodePassword(rawPass, salt);
	}

	/**
	 * 验证密码
	 * 
	 * @param encPass
	 *            密码MD5摘要
	 * @param rawPass
	 *            密码明文
	 * @param salt
	 *            密钥
	 * @return 如果明文与摘要匹配返回true,反之返回false
	 */
	public final static boolean valid(String encPass, String rawPass,
			String salt) {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		md5.setEncodeHashAsBase64(false);

		return md5.isPasswordValid(encPass, rawPass, salt);
	}
}
