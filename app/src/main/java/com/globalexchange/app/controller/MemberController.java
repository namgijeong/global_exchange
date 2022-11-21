
package com.globalexchange.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    @GetMapping("/join")
    public void join(){

    }
    @GetMapping("/joinForm")
    public void joinForm(){

    }
    @GetMapping("/login")
    public void login(){

    }
}
