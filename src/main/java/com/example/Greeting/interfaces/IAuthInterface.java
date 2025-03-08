package com.example.Greeting.interfaces;

import com.example.Greeting.dto.AuthUserDTO;
import com.example.Greeting.dto.LoginDTO;
import com.example.Greeting.dto.PassDTO;
import org.springframework.stereotype.Service;

@Service
public interface IAuthInterface {

        public String register(AuthUserDTO user);

        public String login(LoginDTO user);

        public AuthUserDTO forgotPassword(PassDTO pass, String email);



}
