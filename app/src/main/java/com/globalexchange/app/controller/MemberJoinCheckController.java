package com.globalexchange.app.controller;


import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/*")

public class MemberJoinCheckController {

//    private final MemberService memberService;

    @PostMapping("/joincheckID")
    public String write(@RequestBody MemberVO memberVO){
//        memberService.register(memberVO);
        return "write success";
    }




}























