package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.DiaryVO;
import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.domain.vo.MemberDTO;
import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.repository.FileDAO;
import com.globalexchange.app.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class MemberObjectificationService implements MemberService{

    private final MemberDAO memberDAO;
    private final FileDAO fileDAO;

    @Override
    public boolean checkId(String memberId){

        return memberDAO.checkId(memberId);
    }
    @Override
    public boolean checkNick(String memberNickname){

        return memberDAO.checkNick(memberNickname);
    }
    @Override
    public MemberVO emailLogin(MemberVO memberVO){

        return memberDAO.emailLogin(memberVO);
    }
    @Override
    public void joinForm(MemberVO memberVO){

         memberDAO.joinForm(memberVO);
    }

    //oauth할때 이메일로 멤버가 가입되어있는지 찾기
    @Override
    public MemberVO findByEmail(String memberId){
        return memberDAO.findByEmail(memberId);

    }
    //oauth할때 이메일로 멤버가 가입되어 있으면 email은 같지만 닉네임이 업데이트된채로 로그인할수 있으므로 닉네임 업데이트
    @Override
    public void updateByEmail(String memberId){
        memberDAO.updateByEmail(memberId);
    }
    //oauth할때 이메일로 멤버가 가입되어 있지 않으면 회원가입으로 db에 추가
    @Override
    public void insertByEmail(MemberVO memberVO){
            memberDAO.insertByEmail(memberVO);
    }

    @Override
    public  Long currentJoinMemberNum(){

       return memberDAO.currentJoinMemberNum();
    }

    //google oauth할때 currentJoinMemberNum이 원래 시퀀스랑 오류나서 새로 만듬
    public Long currentJoinMemberNum2(){
        return memberDAO.currentJoinMemberNum2();
    }

    @Override
    public void profileDefaultInsert(FileProfileVO fileProfileVO){
        memberDAO.profileDefaultInsert(fileProfileVO);
    }


//    @Override
//    public void googleJoin(MemberVO memberVO){
//
//        memberDAO.googleJoin(memberVO);
//    }
//    @Override
//    public Long googleLogin(MemberVO memberVO) {
//
//        return memberDAO.googleLogin(memberVO);
//
//    }
    @Override
    public MemberDTO getMypageProfile(Long memberNumber){
       MemberVO memberVO = memberDAO.myPageNickname(memberNumber);
       FileProfileVO fileProfileVO = memberDAO.myPageProfile(memberNumber);

       MemberDTO memberDTO = new MemberDTO();
        memberDTO.create(memberVO,fileProfileVO);

        return memberDTO;
    }

    @Override
    public MemberVO show(Long memberNumber) {
        return memberDAO.findByMemberNumber(memberNumber);
    }


    @Override
    public Long diaryTotalPost(Long memberNumber){
        Long diaryCount = memberDAO.diaryTotalPost(memberNumber);

        return diaryCount;

    }

    @Override
    public Long postTotal(Long memberNumber){
        Long MeetPost = memberDAO.meetPost(memberNumber);
        Long LodgingPost = memberDAO.lodgingPost(memberNumber);


        return MeetPost + LodgingPost;

    }

    @Override
    public Long AnswerTotal(Long memberNumber){
        Long MeetAnswer = memberDAO.meetAnswer(memberNumber);
        Long LodgingAnswer = memberDAO.lodgingAnswer(memberNumber);


        return MeetAnswer + LodgingAnswer;

    }

    @Override
    public List<MemberDTO> diaryPartnerList(Long memberNumber){
        List<Long> partnerList = memberDAO.diaryPartnerList(memberNumber);
        memberDAO.diaryPartnerNickname(memberNumber);
        memberDAO.diaryPartnerProfile(memberNumber);
        List<MemberDTO> partnerDTOList = new ArrayList<>();

        partnerList.forEach(partnerOne -> {
            MemberVO memberVO = memberDAO.diaryPartnerNickname(partnerOne);

            FileProfileVO fileProfileVO = memberDAO.diaryPartnerProfile(partnerOne);

            MemberDTO partnerDTO = new MemberDTO();

            partnerDTO.create(memberVO,fileProfileVO);

            partnerDTOList.add(partnerDTO);


        });


        return partnerDTOList;

    }

    @Override
    public void deletePartner(Long diaryPartnerNumber, Long memberNumber){

        memberDAO.deletePartner(diaryPartnerNumber,memberNumber);
        memberDAO.deletePartner2(diaryPartnerNumber,memberNumber);
    }


    @Override
    public MemberDTO myPageDetail(Long memberNumber){
        MemberDTO memberDTO = new MemberDTO();
//        fileDAO.
        memberDTO.create(memberDAO.myPageDetail(memberNumber), memberDAO.myPageProfile(memberNumber));

        return memberDTO;
    }

    public void myPageContentUpdate(MemberVO memberVO){
        memberDAO.myPageContentUpdate(memberVO);
    }

    public void myPageImageUpdate(FileProfileVO fileProfileVO){
        memberDAO.myPageImageUpdate(fileProfileVO);
    }
}
