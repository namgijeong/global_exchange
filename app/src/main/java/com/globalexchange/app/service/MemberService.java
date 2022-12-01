package com.globalexchange.app.service;


import com.globalexchange.app.domain.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    boolean checkId(String checkId);
    boolean checkNick(String checkNick);
    Long emailLogin(MemberVO memberVO);
    void joinForm(MemberVO memberVO);
//    void googleJoin(MemberVO memberVO);
//    Long googleLogin(MemberVO memberVO);
}


