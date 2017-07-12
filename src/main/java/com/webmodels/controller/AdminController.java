package com.webmodels.controller;

import com.webmodels.dao.PanaModelLinkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    PanaModelLinkDao dao;

    @PostMapping(value = "manageDb")
    public String dbAdmin(
            @RequestParam(value = "reloadDb", required = true) String reloadCommand) {
        boolean isSuccess = false;
        String message = "";
        if (reloadCommand.equals("truncate")) {
            message = "dbTruncate";
            System.out.println("I'm cleaning database.");
            if (dao.truncateLinks()) {
                isSuccess = true;
            } 
        } else if (reloadCommand.equals("load")) {
            message = "dbLoad";
            System.out.println("Loading database...");
            
            if (dao.reloadDb()) {
                isSuccess = true;
                
            }
        }

        return "redirect:/admin?message=" + message + "_"+isSuccess;
    }

    @GetMapping(value = "admin")
    public String admin(@RequestParam(value = "message", required = false) String reloadMessage, Model model) {
        model.addAttribute("message", reloadMessage);
        
        return "admin";
    }

}
