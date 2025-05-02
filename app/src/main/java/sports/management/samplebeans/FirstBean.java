package sports.management.samplebeans;

import org.springframework.stereotype.Component;

@Component
public class FirstBean {

    public void someRandomFunc(){
        System.out.println("created new bean and called");
    }
}
