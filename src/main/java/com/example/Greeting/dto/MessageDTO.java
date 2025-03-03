package com.example.Greeting.dto;

public class MessageDTO {

    String message;
    Long id;

//    Constructor
    public MessageDTO(String message){

        this.message= message;
        this.id= null;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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


