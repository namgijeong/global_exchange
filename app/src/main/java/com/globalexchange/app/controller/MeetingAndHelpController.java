package com.globalexchange.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meetingAndHelp/*")
public class MeetingAndHelpController {

    // 만남과 도움 상세 페이지
    @GetMapping("/detail")
    public void main(){

    }

}
