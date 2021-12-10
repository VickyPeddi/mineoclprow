package com.iocl.dhruva2api.payload;

public class LoginRequest {

	private String username;
	private String password;
	private String secret;
	private String captchaAnswer;

	public LoginRequest() {
		super();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * @return the captchaAnswer
	 */
	public String getCaptchaAnswer() {
		return captchaAnswer;
	}

	/**
	 * @param captchaAnswer the captchaAnswer to set
	 */
	public void setCaptchaAnswer(String captchaAnswer) {
		this.captchaAnswer = captchaAnswer;
	}

}
