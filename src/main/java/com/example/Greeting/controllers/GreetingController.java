package com.example.Greeting.controllers;

import com.example.Greeting.dto.MessageDTO;
import com.example.Greeting.services.GreetingService;
import jakarta.websocket.server.PathParam;
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
    @GetMapping("/service")
    public String serviceGreetings(){
        return gs.getGreetings();
    }

    @GetMapping("/query")
    public String queryGreetings(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName){

        if(firstName!= null && lastName!= null){
            return "Hello "+firstName+" "+ lastName;
        }

        else if(firstName!= null){
            return "Hello "+ firstName;
        }

        else if(lastName!= null){
            return "Hello "+ lastName;
        }
        else
        return "Hello SpringBoot";
    }

    @PostMapping("/save")
    public MessageDTO save(@RequestBody MessageDTO message){
        return gs.saveMessage(message);
    }

    @GetMapping("/find/{id}")
    public MessageDTO findById(@PathVariable Long id) {

        return gs.findById(id);
    }

}

