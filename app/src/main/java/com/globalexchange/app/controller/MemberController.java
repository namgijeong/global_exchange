package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {

//    private final MemberService memberService;

    //회원가입 선택 페이지 이동
    @GetMapping("/join")
    public void join(){

    }

    //중복검사
//    @PostMapping("/checkId")
//    public String checkId(MemberVO memberVO) {
//        boolean i = memberService.checkId(memberVO);
//        if (i) {
//            return "no";
//        }
//
//        return "ok";
//
//    }

    //이메일 회원가입
    @GetMapping("/joinForm")
    public void joinForm(){

    }

    //구글 회원가입
    @GetMapping("/joinGoogle")
    public void joinGoogle(){

    }


    //로그인 선택 페이지 이동
    @GetMapping("/login")
    public void login(){
    }

    //이메일 로그인
    @GetMapping("/emailLogin")
    public void emailLogin(){
    }

    //구글 로그인
    @GetMapping("/googleLogin")
    public void googleLogin(){

    }

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

    // 마이페이지 수정완료
    @GetMapping("/writeOk")
    public void writeOk(){

    }

    // 마이페이지 교환일기 상대 끊기
    @GetMapping("/partnerCancel")
    public void partnerCancel(){

    }

}
