package com.example.Greeting.services;

import com.example.Greeting.dto.MessageDTO;
import com.example.Greeting.entities.MessageEntity;
import com.example.Greeting.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    String message;
    GreetingRepository greetingRepository;


    public GreetingService(GreetingRepository greetingRepository){
        this.greetingRepository= greetingRepository;
        message= "Hey What's up!!";
    }

    public String getGreetings(){
        return this.message;
    }

    public MessageDTO saveMessage(MessageDTO message){

        MessageEntity me = new MessageEntity(message.getMessage());

        greetingRepository.save(me);

        MessageDTO dto = new MessageDTO(me.getMessage());

        dto.setId(me.getId());

        return dto;
    }

    public MessageDTO findById(Long id){

        MessageEntity m1 = greetingRepository.findById(id).orElseThrow(() -> new RuntimeException("No messages found with given id"));

        MessageDTO m2 = new MessageDTO(m1.getMessage());
        m2.setId(m1.getId());

        return m2;

    }
}
