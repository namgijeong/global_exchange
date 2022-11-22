package com.globalexchange.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/needLodging/*")
public class NeedLodgingController {

    // 숙소가 필요해 상세 페이지
    @GetMapping("/detail")
    public void detail(){

    }

    // 숙소가 필요해 목록 페이지
    @GetMapping("/list")
    public void list(){

    }

    // 숙소가 필요해 작성 페이지
    @GetMapping("/write")
    public void write(){

    }
}
