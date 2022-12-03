package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    //회원가입 선택 페이지 이동
    @GetMapping("/member/join")
    public void join(){
    }


    //이메일 회원가입
//    @PostMapping("/member/joinForm")
    @RequestMapping(value = "/member/joinForm")
    public void joinForm(){
    }

    //회원가입 완료 ( 디비 등록 )
    @RequestMapping(value = "/member/joinFormOk")
    public String joinFormOk(MemberVO memberVO){
        memberService.joinForm(memberVO);
        return "/member/login";
    }

    //구글 회원가입
    @GetMapping("/member/joinGoogle")
    public void joinGoogle(){
    }

    //로그인 선택 페이지 이동
    @GetMapping("/member/login")
    public void login(){
    }

//    이메일 로그인
    @PostMapping(value = "/member/emailLogin")
    public RedirectView emailLogin(MemberVO memberVO, HttpServletRequest request) {
        /*log.info(memberVO.getMemberId() + "들어옴"+ memberVO.getMemberPassword());*/

        HttpSession session = request.getSession();
        Long memberNumber = memberService.emailLogin(memberVO);

        /* 일치하는 회원 정보가 없는 경우 */
        if(memberNumber == null){
            return new RedirectView("/member/login");
        /* 일치하는 회원 정보가 있는 경우 회원 번호를 session에 넣는다. */
        }else {
            session.setAttribute("memberNumber" , memberNumber);
            return new RedirectView("/main/main");
        }
    }

//    @PostMapping("/logout")
//    public String logout(@RequestBody)

    //구글 로그인
    @GetMapping("/member/googleLogin")
    public void googleLogin(){

    }

    // 마이페이지 메인
    @GetMapping("/member/mypage")
    public void mypage(){

    }

    // 마이페이지 상세보기
    @GetMapping("/member/detail")
    public void detail(){

    }

    // 마이페이지 수정
    @GetMapping("/member/write")
    public void write(){

    }

    // 마이페이지 수정완료
    @GetMapping("/member/writeOk")
    public void writeOk(){

    }

    // 마이페이지 교환일기 상대 끊기
    @GetMapping("/member/partnerCancel")
    public void partnerCancel(){

    }

}
