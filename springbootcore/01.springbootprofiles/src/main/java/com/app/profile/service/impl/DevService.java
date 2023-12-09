package com.app.profile.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.app.profile.service.GenericService;

@Component
@Profile("default")
public class DevService implements GenericService {
	@Value("${my.profile.code}")
	private String code;

	public DevService(String code) {
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
		return "DevService [code=" + code + "]";
	}

	@Override
	public void executeTask() {
		System.out.println("From Dev Profiles");
		System.out.println("code is " + code);
	}
}