package com.synisys.idm.microservices.authentication;

/**
 * @author ashot.karapetyan on 7/29/16.
 */
public class AuthenticationResult {

	private final String token;

	public AuthenticationResult(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
