package com.demos.integration.spidemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpidemoApplicationTests {
	
	@Autowired
	PollableChannel aChannel;
	
	@Autowired
	PollableChannel bChannel;

	@Test
	public void contextLoads() {
		
		System.out.println(aChannel.receive().getPayload());
		System.out.println(bChannel.receive().getPayload());
		
	}

}
