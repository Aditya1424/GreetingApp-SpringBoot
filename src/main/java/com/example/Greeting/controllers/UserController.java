package com.example.Greeting.controllers;

import com.example.Greeting.dto.LoginDTO;
import com.example.Greeting.dto.MailDTO;
import com.example.Greeting.dto.MessageDTO;
import com.example.Greeting.dto.AuthUserDTO;
import com.example.Greeting.services.AuthenticationService;
import com.example.Greeting.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    EmailService emailService;
    AuthenticationService authenticationService;

    public UserController(EmailService emailService, AuthenticationService authenticationService) {
        this.emailService = emailService;
        this.authenticationService = authenticationService;
    }

    //UC9 --> For Registration of a user
    @PostMapping(path = "/register")
    public String register(@RequestBody AuthUserDTO user){
        return authenticationService.register(user);
    }


    //UC10 --> For User Login
    @PostMapping(path ="/login")
    public String login(@RequestBody LoginDTO user){
        return authenticationService.login(user);
    }

    //UC11 --> For sending mail to another person
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody MailDTO message){
        emailService.sendEmail(message.getTo(), message.getSubject(), message.getBody());
        return "Mail sent";
    }



}

//UC12 --> Added Swagger Config to use Swagger at url(/swagger)