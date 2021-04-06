package cn.sharit.aop.service;

import org.springframework.stereotype.Service;


@Service
public class AOPService {

    public void calc(int xx) {
        System.out.println("xxxService");
        int a = 10 / xx;
    }

}
