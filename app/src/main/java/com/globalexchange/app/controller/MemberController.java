package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    //회원가입 선택 페이지 이동
    @GetMapping("/join")
    public void join(){

    }


    //이메일 회원가입
//    @PostMapping("/joinForm")
    @RequestMapping(value = "/joinForm")
    public String joinForm(MemberVO memberVO){

        if(memberVO==null){
            return "member/joinForm";
        }

        return "member/login";
    }

    //구글 회원가입
    @GetMapping("/joinGoogle")
    public void joinGoogle(){

    }


    //로그인 선택 페이지 이동
    @GetMapping("/login")
    public void login(){
    }


//    이메일 로그인
//    @PostMapping("/emailLogin")
    @RequestMapping(value = "/emailLogin")
    public String emailLogin(MemberVO memberVO, HttpServletRequest request, RedirectAttributes attr) {
            log.info(memberVO.getMemberId() + "들어옴"+ memberVO.getMemberPassword());
        HttpSession session = request.getSession();

        Long memberNumber = memberService.emailLogin(memberVO);


        if(memberNumber == null){

            return "member/login";
        }else {
            session.setAttribute("memberNumber" , memberNumber);

            return "/main/main";
        }


    }

//    @PostMapping("/logout")
//    public String logout(@RequestBody)

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
