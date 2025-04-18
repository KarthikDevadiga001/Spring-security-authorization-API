package com.androidventures.UniMealServer.springboot.Controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class HelloController {

    @GetMapping("/helloji")
    public String greet(HttpServletRequest request){
        return "welcome to hun ki gall kitta"+  request.getSession().getId();
    }

}
