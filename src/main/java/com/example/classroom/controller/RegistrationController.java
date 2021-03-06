package com.example.classroom.controller;


import com.example.classroom.domain.User;
import com.example.classroom.domain.UserInfo;
import com.example.classroom.repos.UserInfoRepo;
import com.example.classroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoRepo userInfoRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String name,
                          @RequestParam String surname,
                          @RequestParam String phone,
                          @RequestParam String middlename,
                          @RequestParam String email,
                          User user, Map<String, Object> model,
                          HttpServletRequest request){
        String user_agent = request.getHeader("user-agent");
        System.out.println(user_agent);
        String[] danni_user_agent = user_agent.split("\\) ");
        System.out.println(danni_user_agent.length);
        String[] danni_op_sys = danni_user_agent[0].split("\\(");
        System.out.println(danni_op_sys[1]);
        String[] danni_op_sys1 = danni_op_sys[1].split("; ");
        System.out.println(danni_op_sys1[1]);

        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setMiddlename(middlename);
        userInfo.setSurname(surname);
        userInfo.setPhone(phone);
      //  user.setEmail(email);
      //  userInfo.setUser(user);
       // userInfoRepo.save(userInfo);
        user.setUserInfo(userInfo);


        System.out.println("--------------------------------1--------------------------------------");
       if (!userService.addUser(user)){
           model.put("message", "user exist");
            return "registration";
       }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String menu(HttpServletRequest request){
        String user_agent = request.getHeader("user-agent");

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        authentication.
        System.out.println("111111");
        return "/login";
    }
@PostMapping("/login")
public void a(){
        System.out.println("njkfnkjndfgkjnfdkgnfdkjngkjfdngjkfngkf");
}
    @GetMapping("/logout")
    public String menuuu(){


        System.out.println("2333333333333322222222222");
        return "redirect:/login?logout";
    }



    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code, User user) {
        boolean isActivated = userService.activateUser(code);


        if (isActivated) {
            model.addAttribute("message", "User successfully activated");

        } else {
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
    }
}

