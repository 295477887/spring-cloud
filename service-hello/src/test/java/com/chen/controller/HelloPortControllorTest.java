package com.chen.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* portControllor Tester. 
* 
* @author chenjie 
* @since 07/16/2018 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloPortControllorTest {

//    @Autowired
//    RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: port(@RequestParam String name)
    *
    */
    @Test
    public void testPort() throws Exception {
        String name="chen";
//        String forObject = restTemplate.getForObject("http://localhost:8081/hi?name=" + name, String.class);
//        Assert.assertEquals("hi " + name + ",i am from port : " + port,forObject);

        HelloPortControllor portControl = new HelloPortControllor();
        String result = portControl.port(name);
        Assert.assertEquals("hi " + name + ",i am from port : " + port,result);


    }


} 
