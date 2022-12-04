package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
   int checkId(String memberId);
   int checkNick(String memberNick);
   Long emailLogin(MemberVO memberVO);
   void joinForm(MemberVO memberVO);

   // Long googleLogin(MemberVO memberVO);
   // Long googleJoin(MemberVO memberVO);

   Long currentJoinMemberNum();
   void profileDefaultInsert(FileProfileVO fileProfileVO);



//   Long googleLogin(MemberVO memberVO);
//   Long googleJoin(MemberVO memberVO);
   MemberVO myPageNickname(Long memberNumber);
   FileProfileVO myPageProfile(Long memberNumber);

//   파트너와 나누고 있는 교환 일기
   Long diaryTotalPost(Long memberNumber);

//   작성한 게시글 갯수
   Long meetPost(Long memberNumber);
   Long lodgingPost(Long memberNumber);

//   작성한 답글 갯수
   Long meetAnswer(Long memberNumber);
   Long lodgingAnswer(Long memberNumber);

//   파트너 리스트
   List<Long> diaryPartnerList(Long memberNumber);
   MemberVO diaryPartnerNickname(Long memberNumber);
   FileProfileVO diaryPartnerProfile(Long memberNumber);


//   파트너 삭제
    void deletePartner(Long diaryPartnerNumber);


//   마이페이지 상세보기
   MemberVO myPageDetail(Long memberNumber);


//   마이페이지 수정
   void myPageContentUpdate(MemberVO memberVO);

//    마이페이지 수정 완료
   void myPageImageUpdate(FileProfileVO fileProfileVO);


//
   public MemberVO select(Long memberNumber);
}
