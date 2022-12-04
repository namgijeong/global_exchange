package com.globalexchange.app.service;


import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.domain.vo.MemberDTO;
import com.globalexchange.app.domain.vo.MemberVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    boolean checkId(String checkId);
    boolean checkNick(String checkNick);
    Long emailLogin(MemberVO memberVO);
    void joinForm(MemberVO memberVO);

    Long currentJoinMemberNum();
    void profileDefaultInsert(FileProfileVO fileProfileVO);

//    void googleJoin(MemberVO memberVO);
//    Long googleLogin(MemberVO memberVO);

    MemberDTO getMypageProfile(Long memberNumber);

    //   파트너와 나누고 있는 교환 일기
    Long diaryTotalPost(Long memberNumber);

    //   작성한 게시글 갯수
    Long postTotal(Long memberNumber);

    //   작성한 답글 갯수
    Long AnswerTotal(Long memberNumber);

    //   파트너 리스트
    List<MemberDTO> diaryPartnerList(Long memberNumber);

    //  파트너 삭제
    void deletePartner(Long diaryPartnerNumber);

    //  마이페이지 상세보기
    MemberDTO myPageDetail(Long memberNumber);

    //  마이페이지 수정
    void myPageContentUpdate(MemberVO memberVO);

    //  마이페이지 수정 완료
    void myPageImageUpdate(FileProfileVO fileProfileVO);
}


