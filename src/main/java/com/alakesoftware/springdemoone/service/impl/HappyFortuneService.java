package com.alakesoftware.springdemoone.service.impl;

import com.alakesoftware.springdemoone.service.FortuneService;

public class HappyFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		
		return "Today is your lucky day!";
	}

}
