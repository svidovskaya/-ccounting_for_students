package com.example.classroom.controller;


import com.example.classroom.domain.*;
import com.example.classroom.repos.*;
import com.example.classroom.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/myAccount")
public class MyAccountController {


@Autowired
private UserRepo userRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoRepo userInfoRepo;


    User user_autent = new User();


    @GetMapping
    public String gr(Model model) throws IOException {
        User user_autent = userService.findAuthUser();

        model.addAttribute("user", user_autent);

        return "myAccount";
    }
    @PostMapping
    public String gr(   @RequestParam String surname,
                        @RequestParam String name,
                        @RequestParam String middlename,
                        @RequestParam String phone,
                        @RequestParam String email,
                        @RequestParam Map<String, String> form,
                        @RequestParam("userId") User user, Model model ){


        UserInfo userInfo = new UserInfo();
        userInfo.setSurname(surname);
        userInfo.setName(name);
        userInfo.setMiddlename(middlename);
        System.out.println(phone);
        userInfo.setPhone(phone);
        user.setEmail(email);
        userInfo.setUser(user);
        System.out.println("------------------MyA-Post------------------------------------");

        userRepo.save(user);
       // userInfoRepo.save(userInfo);
        model.addAttribute("user", user);
        return "myAccount";
    }














}
