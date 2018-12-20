package com.chen;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaClientServiceHiApplicationTests {

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void contextLoads() {
		String result = restTemplate.getForObject("http://localhost:8080/hi", String.class);
		Assert.assertEquals("",result);
	}

}
