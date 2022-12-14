package com.owner.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.owner.feignclient.RoomAuthenticationClient;
import com.owner.model.AuthenticationResponse;

@Service
public class RoomAuthenticationService {
	@Autowired
	RoomAuthenticationClient roomAuthClient;
	
	public boolean isSessionValid(String token) {

		AuthenticationResponse authenticationResponse = roomAuthClient.getValidity(token);
		if (authenticationResponse == null) {
			throw new RuntimeException("Authentication reponse returned as  NULL");
		}

		String role = authenticationResponse.getRole().substring(5);
		if (role.equals("OWNER"))
			return true;
		else
			
			return false;

}
}
