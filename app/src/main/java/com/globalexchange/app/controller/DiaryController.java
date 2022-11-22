package com.globalexchange.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diary/*")
public class DiaryController {

    // 일기 목록 페이지
    @GetMapping("/list")
    public void list(){

    }

    // 일기 상세 페이지
    @GetMapping("/detail")
    public void detail(){

    }

    // 일기 작성 페이지
    @GetMapping("/write")
    public void write(){

    }

    //새로운 교환일기 파트너 신청
    @GetMapping("/newDiaryPartnerSignup")
    public void newDiaryPartnerSignup(){

    }

    // test
    @GetMapping("/test")
    public void test(){

    }
}
