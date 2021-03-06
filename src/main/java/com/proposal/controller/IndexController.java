package com.proposal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class IndexController {

    @GetMapping("/swagger")
    public String swaggerUI() {
        return "redirect:swagger-ui.html";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}


