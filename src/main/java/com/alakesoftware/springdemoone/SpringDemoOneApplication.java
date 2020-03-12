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
	//	System.out.println(trackCoach.getDailyFortune());
		context.close();
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach2 = context3.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context3.getBean("myCoach", Coach.class);
		
		// check if they are the same bean
		boolean result = (theCoach2 == alphaCoach);
		
		// print out the results
		System.out.println("\nPointing to the same object: "+result);
		
		System.out.println("\nMemory location for theCoach2: "+ theCoach2);
		
		System.out.println("\nMemory location for alphaCoach: "+ alphaCoach);
		
		// close the context
		context3.close();
		
		
		// Bean life cycle demo
		
		// load the spring configuration file
		ClassPathXmlApplicationContext beanLifeCycleContext = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach4 = beanLifeCycleContext.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach4.getDailyWorkout());
		
		// close the context
		beanLifeCycleContext.close();
		
	}

}
