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
    MemberVO emailLogin(MemberVO memberVO);
    void joinForm(MemberVO memberVO);

    //oauth할때 이메일로 멤버가 가입되어있는지 찾기
    MemberVO findByEmail(String memberId);
    //oauth할때 이메일로 멤버가 가입되어 있으면 email은 같지만 닉네임이 업데이트된채로 로그인할수 있으므로 닉네임 업데이트
    public void updateByEmail(String memberId);
    //oauth할때 이메일로 멤버가 가입되어 있지 않으면 회원가입으로 db에 추가
    public void insertByEmail(MemberVO memberVO);

    // void googleJoin(MemberVO memberVO);
    // Long googleLogin(MemberVO memberVO);
    public MemberVO show(Long memberNumber);


    Long currentJoinMemberNum();

    //google oauth할때 currentJoinMemberNum이 원래 시퀀스랑 오류나서 새로 만듬
    public Long currentJoinMemberNum2();

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
    void deletePartner(Long diaryPartnerNumber, Long memberNumber);


    //  마이페이지 상세보기
    MemberDTO myPageDetail(Long memberNumber);

    //  마이페이지 수정
    void myPageContentUpdate(MemberVO memberVO);

    //  마이페이지 수정 완료
    void myPageImageUpdate(FileProfileVO fileProfileVO);

}


