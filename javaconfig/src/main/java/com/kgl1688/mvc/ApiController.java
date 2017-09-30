package com.kgl1688.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/users")
    @ResponseBody
    public String getUsers() {
        return "Users: a, b, c";
    }

}
