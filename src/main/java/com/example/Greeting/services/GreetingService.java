package com.example.Greeting.services;

import com.example.Greeting.dto.MessageDTO;
import com.example.Greeting.entities.MessageEntity;
import com.example.Greeting.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<MessageDTO> listAll(){

        List<MessageDTO> list = greetingRepository.findAll().stream().map(entity -> {
            MessageDTO m = new MessageDTO(entity.getMessage());
            m.setId(entity.getId());
            return m;
        }).collect(Collectors.toList());

        return list;
    }

    public MessageDTO editById(MessageDTO message, Long id){

        MessageEntity m = greetingRepository.findById(id).orElseThrow(() -> new RuntimeException("No Message was found with given id"));

        m.setMessage(message.getMessage());

        greetingRepository.save(m);

        MessageDTO m2 = new MessageDTO(m.getMessage());
        m2.setId(m.getId());

        return m2;
    }

    public String delete(Long id){

        MessageEntity m = greetingRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find message with given id"));

        greetingRepository.delete(m);

        return "Message Deleted";

    }


}
