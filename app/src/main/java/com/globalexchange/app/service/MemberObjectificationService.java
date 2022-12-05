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

    @Override
    public  Long currentJoinMemberNum(){

       return memberDAO.currentJoinMemberNum();
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
    public void deletePartner(Long diaryPartnerNumber){
        memberDAO.deletePartner(diaryPartnerNumber);
    }


    @Override
    public MemberDTO myPageDetail(Long memberNumber){
        MemberDTO memberDTO = new MemberDTO();
//        fileDAO.
        memberDTO.create2(memberDAO.myPageDetail(memberNumber));
        memberDTO.setFileProfileVO(memberDAO.myPageProfile(memberNumber));

        return memberDTO;
    }

    public void myPageContentUpdate(MemberVO memberVO){
        memberDAO.myPageContentUpdate(memberVO);
    }

    public void myPageImageUpdate(FileProfileVO fileProfileVO){
        memberDAO.myPageImageUpdate(fileProfileVO);
    }
}
