package org.example.samplebeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondBean {

    @Autowired
    public FirstBean firstBeanParams;

    public void someRandomSecond(){
        System.out.println("called other bean again");
    }
}
