package com.rayneshalucas.budgetapp.controller;

import com.rayneshalucas.budgetapp.models.MyUser;
import com.rayneshalucas.budgetapp.service.MyUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    MyUserService userService;

    @Autowired
    public UserController(MyUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/signupForm")
    public String goToIndex(Model model) {
        model.addAttribute("myUser", new MyUser());
        return "signupForm";

    }

    @PostMapping("/signupUser")
    public String signupUser(@ModelAttribute MyUser myUser, Model model) {
        System.out.println(">> myUser: " + myUser);
        MyUser savedUser = this.userService.saveUser(myUser);
        if (savedUser != null) {
            model.addAttribute("info", "Signup success!");
            return "index";
        } else {
            model.addAttribute("error", "Signup Failed");
            return "signupForm";
        }
    }


    @GetMapping("/loginForm")
    public String loginForm(Model model) {
        model.addAttribute("myUser", new MyUser());
        model.addAttribute("error", "");
        return "loginForm";

    }

    @GetMapping("/userHome")
    public String userHome(Model model, HttpServletRequest request) {

        Object obj = request.getSession().getAttribute("currentUser");
        if (obj == null) {
            model.addAttribute("error", "Login session expired");
            return "redirect:/user/loginForm";
        }

        MyUser currentUser = (MyUser) obj;
        model.addAttribute("myUser", currentUser);
        return "userHome";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute MyUser myUser, Model model, HttpServletRequest request) {
        System.out.println(">> myUser: " + myUser);
        MyUser currentUser = this.userService.authenticateUser(myUser);
        if (currentUser != null) {
            model.addAttribute("myUser", currentUser);
            request.getSession(true).setAttribute("currentUser", currentUser);
            return "userHome";
        } else {
            model.addAttribute("error", "Invalid credentials. Try Again.");
            return "loginForm";
        }
    }


}


