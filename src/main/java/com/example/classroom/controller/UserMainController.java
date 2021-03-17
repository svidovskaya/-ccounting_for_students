package com.example.classroom.controller;


import com.example.classroom.domain.*;
import com.example.classroom.repos.*;
import com.example.classroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/coupl")
public class UserMainController {

//@Autowired
//    SbjctRepo sbjctRepo;
@Autowired
    UserService userService;
//@Autowired
//    GroupsRepo groupsRepo;
@Autowired
    CoupRepo coupRepo;
//    @Autowired
//    CoupQrRepo coupQrRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
            CoupUsrRepo coupUsrRepo;

    User user_autent = new User();

    @GetMapping
    public String m(Model model){

        return "greeting";
    }

    @GetMapping("{couples}")
    public String productEditForm(@PathVariable Couples couples, Model model){
        user_autent = userService.findAuthUser();
        model.addAttribute("coup", couples);
        model.addAttribute("user", user_autent);

        return "coupUser";
    }
    @GetMapping("{couples}/stop")
    public String productEditFo(@PathVariable Couples couples, Model model){
        user_autent = userService.findAuthUser();

        Couples_user couples_user = coupUsrRepo.findByCouplesAndUser(couples, user_autent);
        Time t_stop = Time.valueOf(LocalTime.now());
        couples_user.setT_stop(t_stop);
      //  System.out.println(couples_user.getId().toString());
//     if(t_stop.after(couples.getT_stop())){
//         coupUsrRepo.save(couples_user);
//     }
//      else {
//          System.out.println("---------------ERROR-------------------------");
//     }
        coupUsrRepo.save(couples_user);
        return "greeting";
    }

@PostMapping
public String addSt(String sbj, Long coup,  String surname, String name, String middlename,  Model model ) throws IOException {
Couples_user couples_user = new Couples_user();
    user_autent = userService.findAuthUser();
    couples_user.setUser(user_autent);
   Optional<Couples> co = coupRepo.findById(coup);
    couples_user.setCouples(co.get());
    Time t_start = Time.valueOf(LocalTime.now());
    couples_user.setT_start(t_start);
  //  System.out.println(t_start.toString());
    if (t_start.before(co.get().getT_stop())){
        if(t_start.after(co.get().getT_start())){
            System.out.println("-----AFTER------");
        }
        coupUsrRepo.save(couples_user);
    } else {System.out.println("------------------ERROR!!!!!---------------------------------");}



    return "greeting";
}

    @GetMapping("/myQR")
    public String mh(Model model){
        user_autent = userService.findAuthUser();
        String id = user_autent.getId().toString();
        System.out.println(id);
        String url ="http://qrcoder.ru/code/?"+id+"&4&0";
        model.addAttribute("url", url);


        return "myQR";
    }



}
