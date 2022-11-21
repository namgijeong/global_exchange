package com.globalexchange.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

    // 관리자 멤버 리스트 페이지
    @GetMapping("/memberList")
    public void memberList(){

    }

    // 관리자 멤버 상세보기 페이지
    @GetMapping("/memberDetail")
    public void memberDetail(){

    }

    // 관리자 공지사항 리스트 페이지
    @GetMapping("/noticeList")
    public void noticeList(){

    }

    // 관리자 공지사항 상세보기 페이지
    @GetMapping("/noticeDetail")
    public void noticeDetail(){

    }


    // 관리자 공지사항 업로드 상세보기 페이지
    @GetMapping("/noticeUpload")
    public void noticeUpload(){

    }

    // 관리자 만남과 도움 리스트 페이지
    @GetMapping("/meetingAndHelpList")
    public void meetingAndHelpList(){

    }

    // 관리자 만남과 도움 상세보기 페이지
    @GetMapping("/meetingAndHelpDetail")
    public void meetingAndHelpDetail(){

    }

    // 관리자 숙소가 필요해 리스트 페이지
    @GetMapping("/needLodgingList")
    public void needLodgingList(){

    }

    // 관리자 숙소가 필요해 상세보기 페이지
    @GetMapping("/needLodgingDetail")
    public void needLodgingDetail(){

    }
}
