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

    // 일기 작성 페이지 이동
    @GetMapping("/write")
    public void write(){

    }

    // 일기 작성 완료
    @GetMapping("/writeOk")
    public void writeOk(){

    }

    // 일기 수정 페이지 이동
    @GetMapping("/listUpdate")
    public void listUpdate(){

    }

    // 일기 수정완료
    @GetMapping("/listUpdateOk")
    public void listUpdateOk(){

    }

    // 일기 삭제
    @GetMapping("/listRemove")
    public void listRemove(){

    }

//    // 일기 코멘트 작성
//    @GetMapping("/commentWrite")
//    public void commentWrite(){
//
//    }

    // 일기 코멘트 작성 완료
    @GetMapping("/commentWriteOk")
    public void commentWriteOk(){

    }

//    // 일기 코멘트 수정 페이지 이동
//    @GetMapping("/commentUpdate")
//    public void commentUpdate(){
//
//    }

    // 일기 코멘트 수정 완료
    @GetMapping("/commentUpdateOk")
    public void commentUpdateOk(){

    }

    // 일기 코멘트삭제
    @GetMapping("/CommentRemove")
    public void CommentRemove(){

    }

    //새로운 교환일기 파트너 리스트 이동
    @GetMapping("/newDiaryPartnerList")
    public void newDiaryPartnerList(){

    }

    //새로운 교환일기 파트너 상세보기 이동
    @GetMapping("/newDiaryPartnerDetail")
    public void newDiaryPartnerDetail(){

    }

    //새로운 교환일기 파트너 신청
    @GetMapping("/newDiaryPartnerSignup")
    public void newDiaryPartnerSignup(){

    }

    //새로운 교환일기 파트너 신고
    @GetMapping("/newDiaryPartnerReport")
    public void newDiaryPartnerReport(){

    }
}
