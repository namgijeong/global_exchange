package com.globalexchange.app.repository;//package com.globalexchange.app.repository;


import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.domain.vo.MemberDTO;
import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public MemberVO emailLogin(MemberVO memberVO){

        return memberMapper.emailLogin(memberVO);
    }

    public void joinForm(MemberVO memberVO){

        memberMapper.joinForm(memberVO);

    }


    public MemberVO findByMemberNumber(Long memberNumber) {
        return memberMapper.select(memberNumber);
    }

    //    public Long googleLogin(MemberVO memberVO){

    public Long currentJoinMemberNum(){

        return memberMapper.currentJoinMemberNum();
    }

    public void profileDefaultInsert(FileProfileVO fileProfileVO){
        memberMapper.profileDefaultInsert(fileProfileVO);
    }

//    public Long googleLogin(MemberVO memberVO){

//
//        return memberMapper.googleLogin(memberVO);
//    }
//
//    public void googleJoin(MemberVO memberVO){
//
//        memberMapper.googleJoin(memberVO);
//
//    }

    
//  내 프로필
    
    public MemberVO myPageNickname(Long memberNumber){
        return memberMapper.myPageNickname(memberNumber);
    }


    public FileProfileVO myPageProfile(Long memberNumber){

        return memberMapper.myPageProfile(memberNumber);
    }

//    파트너 나누는 교환일기 갯수

    public Long diaryTotalPost(Long memberNumber){

        return memberMapper.diaryTotalPost(memberNumber);
    }

//    내가 작성한 게시글
    
    public Long meetPost(Long memberNumber){

        return memberMapper.meetPost(memberNumber);
    }

    public Long lodgingPost(Long memberNumber){

        return memberMapper.lodgingPost(memberNumber);
    }

//    내가 작성한 답글 

    public Long meetAnswer(Long memberNumber){

        return memberMapper.meetAnswer(memberNumber);
    }

    public Long lodgingAnswer(Long memberNumber){

        return memberMapper.lodgingAnswer(memberNumber);
    }

//    교환일기 파트너

    public List<Long> diaryPartnerList(Long memberNumber){

        return memberMapper.diaryPartnerList(memberNumber);
    }

    public MemberVO diaryPartnerNickname(Long memberNumber){

        return memberMapper.diaryPartnerNickname(memberNumber);
    }

    public FileProfileVO diaryPartnerProfile(Long memberNumber){

        return memberMapper.diaryPartnerProfile(memberNumber);
    }


//    교환일기 파트너 삭제

    public void deletePartner(Long diaryPartnerNumber){

        memberMapper.deletePartner(diaryPartnerNumber);
    }
    

//  마이페이지 상세보기
    public MemberVO myPageDetail(Long memberNumber){

        return memberMapper.myPageDetail(memberNumber);
    }



//  마이페이지 수정
    public void myPageContentUpdate(MemberVO memberVO){
        memberMapper.myPageContentUpdate(memberVO);
    }

//   마이페잊 수정 완료
    public void myPageImageUpdate(FileProfileVO fileProfileVO){
        memberMapper.myPageImageUpdate(fileProfileVO);
    }

    // 멤버 전체 조회
    public List<MemberVO> findAll(Criteria criteria){
        return memberMapper.selectAll(criteria);
    }

    // 멤버 수 조회
    public int findCountAll(Criteria criteria){
        return memberMapper.getTotal(criteria);
    }

}