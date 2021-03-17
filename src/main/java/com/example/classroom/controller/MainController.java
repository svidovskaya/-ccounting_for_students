package com.example.classroom.controller;


import com.example.classroom.domain.*;
import com.example.classroom.repos.*;
import com.example.classroom.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

@Controller
public class MainController {


    @Autowired
    UserService userService;


    @GetMapping("/")
    public String greeting(Model model, org.apache.catalina.servlet4preview.http.HttpServletRequest request)
    {
        String retu = "greeting";


        return retu;
    }

    @GetMapping("/menu")
    public String main(Model model) {
        model.addAttribute("roles", Role.values());

        return "menu";
    }










}
