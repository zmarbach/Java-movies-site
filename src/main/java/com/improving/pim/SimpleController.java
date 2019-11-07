package com.improving.pim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

    @RequestMapping("/index") //when someone types in url ending in /index it will run this method
    public String index() {
        return "index"; //
    }

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    @RequestMapping("/product")
    public String product() {
        return "product";
    }
}
