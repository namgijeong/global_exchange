package com.globalexchange.app.controller;


import com.globalexchange.app.service.MemberObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/mypagePartner/*")
@Slf4j

public class MemberRemovePartnerController {

    private final MemberObjectificationService memberObjectificationService;

    @RequestMapping(value = "/deletePartner/{diaryPartnerNumber}")
    public void deletePartner(@PathVariable("diaryPartnerNumber") Long diaryPartnerNumber){

        memberObjectificationService.deletePartner(diaryPartnerNumber);


    }




}























