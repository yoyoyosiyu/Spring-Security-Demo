package com.kgl1688.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/secure")
public class SecureController {

    @RequestMapping("/userinfo")
    @ResponseBody
    public String getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            return ((User)authentication.getPrincipal()).getUsername();
        }

        return null;
    }

    @RequestMapping("/admin/dosomething")
    @ResponseBody
    public String doSomething() {
        return "do something";
    }
}
