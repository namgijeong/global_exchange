package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class MemberObjectificationService implements MemberService{

    private final MemberDAO memberDAO;

    @Override
    public boolean checkId(String memberId){

        return memberDAO.checkId(memberId);
    }
    @Override
    public boolean checkNick(String memberNickname){

        return memberDAO.checkNick(memberNickname);
    }
    @Override
    public Long emailLogin(MemberVO memberVO){

        return memberDAO.emailLogin(memberVO);
    }
    @Override
    public void joinForm(MemberVO memberVO){

         memberDAO.joinForm(memberVO);
    }

    @Override
    public MemberVO show(Long memberNumber) {
        return memberDAO.findByMemberNumber(memberNumber);
    }


}
