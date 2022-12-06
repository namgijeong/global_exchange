package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.repository.MeetDAO;
import com.globalexchange.app.repository.MemberDAO;
import com.globalexchange.app.repository.MemberReportDAO;
import com.globalexchange.app.repository.NoticeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final MemberDAO memberDAO;
    private final MemberReportDAO memberReportDAO;
    private final MeetDAO meetDAO;
    private final NoticeDAO noticeDAO;

    // 멤버 리스트
    public List<MemberVO> showAllMember(Criteria criteria){
        return memberDAO.findAll(criteria);
    }

    // 멤버 전체 수 조회
    public int getTotalMember(Criteria criteria){
        return memberDAO.findCountAll(criteria);
    }

    // 멤버 상세 조회
    public MemberDTO showMemberDetail(Long memberNumber){
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.create(memberDAO.findByMemberNumber(memberNumber),
                memberReportDAO.findReportsCount(memberNumber));

        return memberDTO;
    }

    // 멤버 삭제
    public void removeMember(Long memberNumber){
        memberDAO.removeMember(memberNumber);
    }

    // 만남과 도움 게시글 조회
    public List<MeetDTO> showAllMeet(Criteria criteria){
        List<MeetVO> meetVOList = meetDAO.meetSelectAll(criteria);
        List<MeetDTO> meetDTOList = new ArrayList<>();

        for (MeetVO meetVO : meetVOList){
            MeetDTO meetDTO = new MeetDTO();
            Long memberNumber = meetVO.getMemberNumber();
            String memberTeachingLang = memberDAO.findByMemberNumber(memberNumber).getMemberTeachingLang();
            String nickName = memberDAO.findByMemberNumber(memberNumber).getMemberNickname();

            meetDTO.create(meetVO, memberTeachingLang, nickName);

            meetDTOList.add(meetDTO);
        }

        return meetDTOList;
    }

    // 만남과 도움 전체 게시글 수 조회
    public int getTotalMeet(){
        return meetDAO.getTotal();
    }

    // 만남과 도움 게시글 상세 조회
    public MeetDTO showMeetDetail(Long meetNumber){
        MeetDTO meetDTO = new MeetDTO();
        Long memberNumber = meetDAO.selectMeetRequest(meetNumber).getMemberNumber();



        String memberTeachingLang = memberDAO.findByMemberNumber(memberNumber).getMemberTeachingLang();
        String memberNickname = memberDAO.findByMemberNumber(memberNumber).getMemberNickname();

        meetDTO.create(meetDAO.selectMeetRequest(meetNumber), memberTeachingLang, memberNickname);

        return meetDTO;
    }

    // 만남과 도움 게시글 삭제
    public void removeMeet(Long meetNumber){
        meetDAO.removeMeet(meetNumber);
    }

    // 공지사항 등록
    public void register(NoticeVO noticeVO) {
        noticeDAO.save(noticeVO);
    }

    // 공지사항 수정
    public void modify(NoticeVO noticeVO) {
        noticeDAO.setNoticeVO(noticeVO);
    }

    // 공지사항 삭제
    public void remove(Long noticeNumber) {
        noticeDAO.remove(noticeNumber);
    }

    // 공지사항 상세
    public NoticeVO show(Long noticeNumber) {
        return noticeDAO.findById(noticeNumber);
    }

    // 공지사항 리스트
    public List<NoticeVO> showAll(Criteria criteria) {
        return noticeDAO.findAll(criteria);
    };

    // 공지사항 전체 개수 조회
    public int getTotal() {
        return noticeDAO.findCountAll();
    }
}
