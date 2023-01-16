package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
   int checkId(String memberId);
   int checkNick(String memberNick);
   MemberVO emailLogin(MemberVO memberVO);
   void joinForm(MemberVO memberVO);
   //oauth할때 이메일로 멤버가 가입되어있는지 찾기
   MemberVO findByEmail(String memberId);
   //oauth할때 이메일로 멤버가 가입되어 있으면 email은 같지만 닉네임이 업데이트된채로 로그인할수 있으므로 닉네임 업데이트
   void updateByEmail(String memberId);
   //oauth할때 이메일로 멤버가 가입되어 있지 않으면 회원가입으로 db에 추가
   void insertByEmail(MemberVO memberVO);
   // Long googleLogin(MemberVO memberVO);
   // Long googleJoin(MemberVO memberVO);


   Long currentJoinMemberNum();

   //google oauth할때 currentJoinMemberNum이 원래 시퀀스랑 오류나서 새로 만듬
   Long currentJoinMemberNum2();
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
   void deletePartner(Long diaryPartnerNumber, Long memberNumber);
   void deletePartner2(Long diaryPartnerNumber, Long memberNumber);


   //   마이페이지 상세보기
   MemberVO myPageDetail(Long memberNumber);


   //   마이페이지 수정
   void myPageContentUpdate(MemberVO memberVO);

   //    마이페이지 수정 완료
   void myPageImageUpdate(FileProfileVO fileProfileVO);

   // 멤버 조회
   public MemberVO select(Long memberNumber);

   // 멤버 전체 조회
   public List<MemberVO> selectAll(Criteria criteria);

   // 멤버 수 조회
   public int getTotal(Criteria criteria);

   // 멤버 삭제
   public void deleteMember(Long memberNumber);
}
