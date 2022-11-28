package com.globalexchange.app.repository;//package com.globalexchange.app.repository;


import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberDAO {
    private final MemberMapper memberMapper;

    public boolean checkId(String memberId){
        log.info("매개변수 들어옴"+memberId);
        int n = memberMapper.checkId(memberId);
        log.info("조회한 멤버 번호"+ n);
        if(n > 0){

            return false ;
        }
        return true;
    }

    public boolean checkNick(String memberNick){
        int n = memberMapper.checkNick(memberNick);
        log.info("조회한 닉네임 번호"+ n);
        if(n > 0){

            return false ;
        }
        return true;
    }

    public Long emailLogin(MemberVO memberVO){

        return memberMapper.emailLogin(memberVO);
    }

    public boolean joinForm(MemberVO memberVO){
        int n = memberMapper.joinForm(memberVO);
        return n > 0;
    }



}