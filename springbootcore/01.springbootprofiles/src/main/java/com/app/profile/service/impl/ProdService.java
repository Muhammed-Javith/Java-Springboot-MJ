package com.app.profile.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.app.profile.service.GenericService;

@Component
@Profile("prod")
public class ProdService implements GenericService {
	@Value("${my.profile.code}")
	private String code;

	public ProdService() {
		super();
	}

	public ProdService(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ProdService [code=" + code + "]";
	}

	public void executeTask() {
		System.out.println("From Prod Profile");
		System.out.println("code is " + code);
	}
}