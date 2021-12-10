package com.iocl.dhruva2api.model.login;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

@Entity
@Table(name = "invalid_credentials_count")
public class InvalidCredentialLogin {

	@Id
	@Column(name = "EMP_CODE")
	private int empCode;
	
	@Column(name = "CONTIGUOUS_WRONG_COUNT")
	private int wrongCount;
	
	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "LOGIN_ATTEMPT_DATE")
	private LocalDateTime lastInvalidAttemptTime;

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public int getWrongCount() {
		return wrongCount;
	}

	public void setWrongCount(int wrongCount) {
		this.wrongCount = wrongCount;
	}

	public InvalidCredentialLogin(int empCode, int wrongCount,LocalDateTime localDateTime) {
		super();
		this.empCode = empCode;
		this.wrongCount = wrongCount;
		this.lastInvalidAttemptTime = localDateTime;
	}
	
	public InvalidCredentialLogin(int empCode, int wrongCount) {
		super();
		this.empCode = empCode;
		this.wrongCount = wrongCount;
	}
	
	public void increaseWrongCount() {
		this.wrongCount++;
	}

	public LocalDateTime getLastInvalidAttemptTime() {
		return lastInvalidAttemptTime;
	}

	public void setLastInvalidAttemptTime(LocalDateTime lastInvalidAttemptTime) {
		this.lastInvalidAttemptTime = lastInvalidAttemptTime;
	}

	public InvalidCredentialLogin() {
		super();
	}
	

	
}
