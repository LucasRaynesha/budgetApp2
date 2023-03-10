package com.perscholas.budgetapp.controller;

import com.perscholas.budgetapp.models.MyUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
    @RequestMapping(value="registration", method= RequestMethod.GET)
    public String getRegister (ModelMap model) {
        MyUser user = new MyUser();
        model.put("user", user);
        return "registration";
    }
}
