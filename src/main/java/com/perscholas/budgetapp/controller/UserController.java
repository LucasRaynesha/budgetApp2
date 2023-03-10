package com.perscholas.budgetapp.controller;

import com.perscholas.budgetapp.models.MyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class UserController {

    @RequestMapping(value="index", method=RequestMethod.GET)
    public String getMyLogin (ModelMap model)
    {
        MyUser user = new MyUser();
        model.put("user", user);

        return ("index");
    }

}


