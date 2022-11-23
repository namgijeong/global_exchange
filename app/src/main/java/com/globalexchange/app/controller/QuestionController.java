package com.globalexchange.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question/*")
public class QuestionController {

    // 문의사항 작성 페이지 이동
    @GetMapping("/question")
    public void question(){

    }

    // 문의사항 작성 완료
    @GetMapping("/questionWriteOk")
    public void questionWriteOk(){

    }

}
