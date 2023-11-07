package com.example.enotes.controllers;

import com.example.enotes.entities.UserDtls;
import com.example.enotes.services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/signup")
    public String signup(){

        return "signup";
    }

    @PostMapping("/signup")
    public String save(@ModelAttribute UserDtls user, HttpSession session){

        UserDtls u = userService.saveUser(user);
        if(u != null){
            session.setAttribute("msg", "Registration is Saved Successfully");
        }else{
            session.setAttribute("msg", "Something is Wrong");
        }
        return "redirect:/signup";
    }

}
