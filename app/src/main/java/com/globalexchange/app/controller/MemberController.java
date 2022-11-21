package com.globalexchange.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    // 마이페이지 메인
    @GetMapping("/mypage")
    public void mypage(){

    }

    // 마이페이지 상세보기
    @GetMapping("/detail")
    public void detail(){

    }

    // 마이페이지 수정
    @GetMapping("/write")
    public void write(){

    }

}
