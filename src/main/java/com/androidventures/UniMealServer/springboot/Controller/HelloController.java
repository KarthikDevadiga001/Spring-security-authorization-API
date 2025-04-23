package com.androidventures.UniMealServer.springboot.Controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.http.HttpRequest;

@RestController
public class HelloController {
    @Secured("ADMIN")
    @GetMapping("/admin/hello")
    public String greet(HttpServletRequest request){
        return "hello admin "+  request.getSession().getId();
    }
}
