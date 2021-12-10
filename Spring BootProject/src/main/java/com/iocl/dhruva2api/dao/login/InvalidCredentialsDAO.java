package com.iocl.dhruva2api.dao.login;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.login.InvalidCredentialLogin;

public interface InvalidCredentialsDAO extends CrudRepository<InvalidCredentialLogin, Integer> {
	

}
