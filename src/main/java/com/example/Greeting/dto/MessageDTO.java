package com.example.Greeting.dto;

public class MessageDTO {

    String message;

//    Constructor
    public MessageDTO(String message){
        this.message= message;
    }

//    Getter
    public String getMessage(){
        return message;
    }

//    Setter
    public void setMessage(String message){
        this.message= message;
    }

}
