package com.jnu.gulimall.ware;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GulimallWareApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(new Date());
    }

    @Test
    public void testDate() {
        System.out.println(new Date());
    }

}
