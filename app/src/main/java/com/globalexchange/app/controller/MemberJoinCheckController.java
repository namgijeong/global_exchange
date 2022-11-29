package com.globalexchange.app.controller;


import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.service.MemberObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memberJoinCheck/*")
@Slf4j

public class MemberJoinCheckController {

    private final MemberObjectificationService memberObjectificationService;

    @PostMapping("/joinCheckId")
    public boolean checkId(@RequestBody String memberId){
        log.info("아이디 체크 컨트롤러 들어옴"+ memberId);


        boolean check = memberObjectificationService.checkId(memberId);

        log.info("" + check);
        return check;
    }

    @PostMapping("/joinCheckNickname")
    public boolean checkNick(@RequestBody String memberNickname){
        log.info("닉네임 체크 컨트롤러 들어옴");


        boolean check = memberObjectificationService.checkNick(memberNickname);

        log.info("" + check);
        return check;
    }


}























