package cn.sharit.aop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AOPService {

    @Transactional
    public Integer calc(int xx) {
        System.out.println("xxxService");
        int a = 10 / xx;
        return 123;
    }

}
