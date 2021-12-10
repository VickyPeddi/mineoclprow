package com.iocl.dhruva2api.util;

public interface MessageConstants {

	String INVALID_TOKEN = "Invalid Token";
	String VALID_TOKEN = "Valid token for user ";
	String USERNAME_OR_PASSWORD_EMPTY = "Username or Password should not be empty";
	String USERNAME_OR_PASSWORD_INVALID = "Username or Password is not valid, your account will be locked for 12 hours after 15 continuous unsuccessful attempts.";
	String CONTIGUOUS_FAILED_LOGIN_COUNT_EXCEEDED = "More than 15 failed login attempted, please try after 12 hours";
	String CAPTCHA_ANSWER_MISMATCH = "Provided Captcha answer is invalid";
}
