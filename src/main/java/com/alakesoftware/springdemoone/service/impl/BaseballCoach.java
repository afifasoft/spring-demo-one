package com.alakesoftware.springdemoone.service.impl;

import com.alakesoftware.springdemoone.service.Coach;
import com.alakesoftware.springdemoone.service.FortuneService;

public class BaseballCoach implements Coach{
	
	private FortuneService fortuneService;
	
	
	
	public BaseballCoach() {
		
	}



	// ctr injection or dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorkout() {
		
		return "Spend 30 min on batting practice";
	}



	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
