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

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;


@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/panel")
public class AdminMainController {

@Autowired
    SbjctRepo sbjctRepo;
@Autowired
    UserService userService;
@Autowired
    GroupsRepo groupsRepo;
@Autowired
    CoupRepo coupRepo;
    @Autowired
    CoupQrRepo coupQrRepo;

    @Autowired
    CoupUsrRepo coupUsrRepo;

    User user_autent = new User();

    @GetMapping
    public String m(Model model){

        return "panelAdmin";
    }

    @GetMapping("createcoup")
        public String greeting(Model model)
    {
        user_autent = userService.findAuthUser();
        System.out.println("___________________panel______________________________");
        List<Sbjct> sbjcts = sbjctRepo.findByUser(user_autent);
        List<Groups> groups = groupsRepo.findAll();

        model.addAttribute("sbjct", sbjcts);
        model.addAttribute("groups", groups);

        return "coupCreate";
    }
    @PostMapping("/coupCreate")
    public String addProd(Couples couples, Sbjct sbjct, Groups groups, int numb_coup, Model model ) throws IOException {
System.out.println(groups.getName());
        System.out.println(sbjct.getName());
//        File uploadDir = new File(uploadPath);
//        String resultFN = kode+".jpg";
//        file.transferTo(new File(uploadPath+"/"+resultFN));
        couples.setSbjct(sbjct);
        couples.setGroups(groups);
        couples.setDate(LocalDate.now());
      //  couples.setT_start(t_start);
      //  couples.setT_stop(t_stop);
System.out.println(numb_coup);
Time t_start = Time.valueOf("00:00:00");
        Time t_stop = Time.valueOf("00:00:00");
        switch (numb_coup) {
            case 1: t_start=Time.valueOf("08:00:00");
                    t_stop=Time.valueOf("09:20:00");
                break;
            case 2:t_start=Time.valueOf("09:30:00");
                    t_stop=Time.valueOf("10:50:00");
                break;
            case 3:t_start=Time.valueOf("11:20:00");
                t_stop=Time.valueOf("12:40:00");
                break;
            case 4:t_start=Time.valueOf("12:50:00");
                t_stop=Time.valueOf("14:10:00");
                break;
            case 5:t_start=Time.valueOf("14:20:00");
                t_stop=Time.valueOf("15:40:00");
                break;
            case 6:t_start=Time.valueOf("15:50:00");
                t_stop=Time.valueOf("17:10:00");
                break;
            case 7:t_start=Time.valueOf("17:20:00");
                t_stop=Time.valueOf("18:40:00");
                break;
            case 8:t_start=Time.valueOf("18:50:00");
                t_stop=Time.valueOf("20:10:00");
                break;
            default:
                break;
        }


        couples.setT_start(t_start);
        couples.setT_stop(t_stop);
//        URL url = new URL("http%3A%2F%2F192.168.1.2%3A8080%2Fpanel&4&0");
//        BufferedImage img = ImageIO.read(url);
//        File file = new File("D:\\image\\downloaded.jpg");
//        ImageIO.write(img, "jpg", file);

      coupRepo.save(couples);
        CoupQr coupQr = new CoupQr();
        coupQr.setCouples(couples);
        String id_c = couples.getId().toString();
        String ur = "http://qrcoder.ru/code/?http%3A%2F%2F192.168.1.2%3A8080%2Fcoupl%2F"+id_c+"&4&0";

        coupQr.setName_start(ur);
        coupQrRepo.save(coupQr);

        List<CoupQr> coupQrs = coupQrRepo.findAll();
        model.addAttribute("coupQrs", coupQrs);
//        Iterable<Product> products = productRepo.findAll();
//        model.addAttribute("products", products);

        return "coupNow";
    }

    @GetMapping("coupNow")
    public String greet(Model model)
    {

        user_autent = userService.findAuthUser();

        List<CoupQr> coupQrs = coupQrRepo.findAll();
        model.addAttribute("coupQrs", coupQrs);

        return "coupNow";
    }
    @GetMapping("coupNow/{couples}")
    public String gree(@PathVariable Couples couples, Model model)
    {
        List<Couples_user> couples_users = coupUsrRepo.findByCouples(couples);
        System.out.println(couples_users.size());
        model.addAttribute("users", couples_users);

        return "coupUserListNow";
    }

    @PostMapping("coupNow/{couples}")
    public String gre(@PathVariable Couples couples, Model model)
    {
//        List<Couples_user> couples_users = coupUsrRepo.findByCouples(couples);
//        System.out.println(couples_users.size());
//        model.addAttribute("users", couples_users);
System.out.println("_____________________________POST_COUP____________________________________________");
        CoupQr coupQr = coupQrRepo.findByCouples(couples);

        String id_c = couples.getId().toString();
        String ur = "http://qrcoder.ru/code/?http%3A%2F%2F192.168.1.2%3A8080%2Fcoupl%2F"+id_c+"%2Fstop&4&0";
        coupQr.setName_stop(ur);
        coupQrRepo.save(coupQr);

        model.addAttribute("qr", coupQr);
        return "coupStop";

    }


//    @GetMapping("{product}/delete")
//    public String productDelete(@PathVariable Product product, Model model){
//        productRepo.delete(product);
//        Iterable<Product> products = productRepo.findAll();
//        model.addAttribute("products", products);
//        return "productList";
//    }
//    @GetMapping("/{product}/edit")
//    public String productEdit(@PathVariable Product product, Model model){
//        System.out.println("-----------------EDIT----GET--------------------");
//        model.addAttribute("product", product);
//        model.addAttribute("manufacturers", manufRepo.findAll());
//        return "productEdit";
//    }
//    @PostMapping("")
//    public String productEditt(@RequestParam Long prodId, Model model, Product product, String shtrih, String kode, String name, String discript, String discription, Float price, Manufacturer manufacturer){
//        System.out.println("-----------------EDIT----POST--------------------");
//        //  int id = Integer.parseInt(String.valueOf(prodId));
//        Optional<Product> product1 = productRepo.findById(prodId);
//
//        product1.get().setShtrih(shtrih);
//        product1.get().setKode(kode);
//        product1.get().setName(name);
//        product1.get().setDiscript(discript);
//        product1.get().setDiscription(discription);
//        product1.get().setPrice(price);
//        product1.get().setManufacturer(manufacturer);
//        productRepo.save(product1.get());
//
//        Iterable<Product> products = productRepo.findAll();
//        model.addAttribute("products", products);
//        return "productList";
//    }
//






}
