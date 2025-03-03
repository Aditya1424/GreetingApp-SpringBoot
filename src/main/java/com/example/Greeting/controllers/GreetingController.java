package com.example.Greeting.controllers;

import com.example.Greeting.dto.MessageDTO;
import com.example.Greeting.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
//    @Autowired
    GreetingService gs;

//    This is constructor injection
    public GreetingController(GreetingService gs){
        this.gs= gs;
    }

    @GetMapping("/get")
    public String getGreetings(){
        return "{\"message\": \"Hello from GET Request!\"}";
    }

    @PostMapping("/post")
    public String postGreetings(@RequestBody MessageDTO mssg){
        return "{\""+mssg.getMessage()+": \"Hello from POST Request!\"}";
    }

    @PutMapping("/put/{message}")
    public String putGreetings(@PathVariable String message){
        return "{\""+message+": \"Hello from PUT Request!\"}";

    }

    public String serviceGreetings(){
        return gs.getGreetings();
    }




}
