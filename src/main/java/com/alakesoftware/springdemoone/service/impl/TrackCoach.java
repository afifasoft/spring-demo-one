package com.alakesoftware.springdemoone.service.impl;

import com.alakesoftware.springdemoone.service.Coach;
import com.alakesoftware.springdemoone.service.FortuneService;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	
	
	public TrackCoach() {
		
	}

	public TrackCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just do it: "+fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside method doMyCleanupStuff");
	}
}
