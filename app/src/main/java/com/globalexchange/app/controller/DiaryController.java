package com.globalexchange.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diary/*")
public class DiaryController {

    // 일기 상세 페이지
    @GetMapping("/info")
    public void main(){

    }

}
