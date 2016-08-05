package com.synisys.idm.bookstoreservice.remote.authentication;

/**
 * @author ashot.karapetyan on 7/29/16.
 */
class AuthenticationServiceFallback
		implements AuthenticationServiceBookstoreFeign {

	@Override
	public String authenticateInBookStoreService() {
		return "";
	}
}
