package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DiaryService {
    //    추가
    public void register(DiaryDTO diaryDTO);
    //    수정
    public void modify(DiaryDTO diaryDTO);
    //    삭제
    public void remove(Long diaryNumber);
    //    조회
    public DiaryDTO show(Long diaryNumber);
    //    파트너가 나에게 일기 썼을 때 조회
    public DiaryDTO showWrittenByPartner(Long diaryNumber);
    //    전체 조회
    public List<DiaryDTO> showAll(Criteria criteria);

    //  내가 쓴 일기 전체 조회
    public List<DiaryDTO> myDiarySelectAll(Criteria criteria, Long memberNumber);
    // 나와 특정 파트너의 일기 내용
    public List<DiaryDTO> myPartnerSelectAll(Long memberNumber, Long diaryPartnerNumber, Criteria criteria);

    //  파트너가 나에게 쓴 일기 전체 조회
    public List<DiaryDTO> toMeDiarySelectAll(Criteria criteria, Long memberNumber);
    //  특정 파트너가 나에게 쓴 일기 전체 조회
    public List<DiaryDTO> toMeFromPartnerDiarySelectAll(Criteria criteria, Long memberNumber, Long diaryPartnerNumber);

    //    전체 개수
    public int getTotal();

    //  내가 쓴 일기 전체 개수
    public int myDiaryGetTotal(Long memberNumber);
    // 나와 특정 파트너의 일기 수
    public int categoryGetTotal(Long memberNumber, Long diaryPartnerNumber);

    //  파트너가 나에게 쓴 일기 전체 개수
    public int toMeDiaryGetTotal(Long memberNumber);
    //  특정 파트너가 나에게 쓴 일기 전체 개수
    public int toMeFromPartnerDiaryGetTotal(Long memberNumber, Long diaryPartnerNumber);

    // 파트너 리스트 조회
    public List<MemberDTO> showAllPartner(Criteria criteria);

    // 파트너 수 조회
    public int getTotal(Criteria criteria);

    // 파트너 상세 정보 조회
    public MemberDTO showPartnerDetail(Long memberNumber);

    // 파트너 조회
    public List<MemberDTO> showPartner(Long memberNumber);

    // 파트너 등록
    public void registerPartner(Long memberNumber, Long diaryPartnerNumber);

    // 파트너 유무 확인
    public int diaryPartnerCheck(Long memberNumber, Long diaryPartnerNumber);

    // 파트너 신고
    public void registerReport(Long reportingMemberNumber, Long reportedMemberNumber);

    // 코멘트 조회
    public List<DiaryCommentDTO> diaryCommentSelectAll(Criteria criteria, Long diaryNumber);

    // 코멘트 개수
    public int diaryCommentCount(Long diaryNumber);

    // 코멘트 추가
    public void diaryCommentInsert(DiaryCommentVO diaryCommentVO);

    // 코멘트 수정
    public void diaryCommentUpdate(DiaryCommentVO diaryCommentVO);

    // 코멘트 삭제
    public void diaryCommentDelete(Long diaryCommentNumber);
}


