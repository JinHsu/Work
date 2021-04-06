package cn.sharit.aop;

import cn.sharit.Application;
import cn.sharit.aop.service.AOPService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class AOPServiceTest {

    @Autowired
    AOPService aopService;

    @Test
    public void testAopSpring4() {
        System.out.println("SpringBoot Version: " + SpringBootVersion.getVersion());
        System.out.println("Spring Version: " + SpringVersion.getVersion());
        System.out.println();
        aopService.calc(2);
    }

    @Test
    public void testAopSpring4Exception() {
        System.out.println("SpringBoot Version: " + SpringBootVersion.getVersion());
        System.out.println("Spring Version: " + SpringVersion.getVersion());
        System.out.println();
        aopService.calc(0);
    }

}
