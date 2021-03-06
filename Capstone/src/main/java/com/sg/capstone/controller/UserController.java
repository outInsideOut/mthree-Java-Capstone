package com.sg.capstone.controller;

import com.sg.capstone.models.User;
import com.sg.capstone.service.UserDetailsService;
import com.sg.capstone.service.UsernameFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value={"/logon.html"}, method= RequestMethod.GET)
    public String logon() {
        return "logon";
    }

    @GetMapping("userDetails")
    public String getUserDetails(HttpServletRequest request, Model model) throws UsernameFoundException {
        String userName = request.getParameter("userName");
        User user = userDetailsService.getUserDetails(userName);
        model.addAttribute("user", user);
        return "userDetails";
    }
}
