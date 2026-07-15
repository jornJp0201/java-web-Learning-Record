package com.example.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class Hello{
   
   
    @GetMapping("/")
    public String index() {
        return "index";
    }

@GetMapping("/hello_test")
public String sayHello(){
        
        return "result";
}


@GetMapping("/login")
public String login() {
    return "login";
}



@GetMapping("/add_text")
  public String Registr_Page(){
    return "add_text";
  }

 
  public String getMethodName(@RequestParam String param) {
      return new String();
  }
  
        



}


