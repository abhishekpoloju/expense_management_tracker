package practice.spring.mvc.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MainController {

    @GetMapping("/test")
    public String doget(){
        return  "test";
    }

    @GetMapping(value = "/best", produces = MediaType.ALL_VALUE, consumes = MediaType.ALL_VALUE)
    public String roget(){
        HashMap<String, String> h1 = new HashMap<>();
        h1.put("hi","value");
        h1.put("yo","to");
        System.out.println("do best");
        return  "best";
    }

    @GetMapping("/customlogin")
    public String login() {
        return "login";
    }

}
