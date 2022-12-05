package com.globalexchange.app.controller;


import com.globalexchange.app.service.MemberObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/mypagePartner/*")
@Slf4j

public class MemberRemovePartnerController {

    private final MemberObjectificationService memberObjectificationService;

    @RequestMapping(value = "/deletePartner/{diaryPartnerNumber}")
    public void deletePartner(HttpServletRequest request, @PathVariable("diaryPartnerNumber") Long diaryPartnerNumber){
        HttpSession session = request.getSession();
        Long memberNumber = (Long)session.getAttribute("memberNumber");
        memberObjectificationService.deletePartner(diaryPartnerNumber,memberNumber);


    }




}























