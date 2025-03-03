package com.example.Greeting.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    String message;

    GreetingService(){
        message= "Hey What's up!!";
    }

    public String getGreetings(){
        return this.message;
    }
}
