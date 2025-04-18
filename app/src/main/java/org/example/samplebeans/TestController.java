package org.example.samplebeans;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    @GetMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @ResponseBody
    public HashMap<String, String> doget(){
        HashMap<String, String> h1 = new HashMap<>();
        h1.put("hi","value");
        h1.put("yo","to");
        return  h1;
    }
}
