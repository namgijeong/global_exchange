package com.globalexchange.app.repository;//package com.globalexchange.app.repository;


import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    public boolean checkId(String checkId){
        int n = memberMapper.checkId(checkId);
        if(n > 0){

            return false ;
        }
        return true;
    }

    public boolean join(MemberVO memberVO){
        int n = memberMapper.join(memberVO);
        return n > 0;
    }

    public MemberVO login(MemberVO memberVO){
        return memberMapper.login(memberVO);
    }



}