package com.alakesoftware.springdemoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alakesoftware.springdemoone.service.Coach;
import com.alakesoftware.springdemoone.service.impl.BaseballCoach;
import com.alakesoftware.springdemoone.service.impl.CricketCoach;
import com.alakesoftware.springdemoone.service.impl.HappyFortuneService;
import com.alakesoftware.springdemoone.service.impl.TrackCoach;

// 43
@SpringBootApplication
public class SpringDemoOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoOneApplication.class, args);
		Coach theCoach = new BaseballCoach();
		System.out.println(theCoach.getDailyWorkout());
		
		Coach trackCoach = new TrackCoach();
		System.out.println(trackCoach.getDailyWorkout());
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach tCoach = context.getBean("myCoach", Coach.class);
		System.out.println(tCoach.getDailyWorkout());
		
		// load the spring configuration file
		ClassPathXmlApplicationContext  context2 = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		CricketCoach cricketCoach = context2.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		System.out.println(cricketCoach.getEmailAddress());
		System.out.println(cricketCoach.getTeam());
		// close the context
		context2.close();
		
		System.out.println(tCoach.getDailyFortune());
		System.out.println(trackCoach.getDailyFortune());
		context.close();
	}

}
