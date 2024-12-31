package com.rudraksh.rest.webservices.restful_web_services.helloWorld.controller;

import com.rudraksh.rest.webservices.restful_web_services.helloWorld.dto.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200") // this will allow all the requests from the url mentioned to fire our apis
@RestController
public class BasicAuthenticationController {

    //@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
//    @GetMapping(path = "/helloWorld")
//    public String helloWorld() {
//        return "Hello World";
//    }

    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean() {
        //throw new RuntimeException("Something went wrong! Please try later.");
        return new AuthenticationBean("Authentication Successful!");
    }

    @GetMapping(path = "/helloWorld/pathVariable/{name}")
    public AuthenticationBean helloWorldPathVariable(@PathVariable String name) {
        return new AuthenticationBean(String.format("Hello World, %s", name));
    }
}
