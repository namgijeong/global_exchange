package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.repository.FileDAO;
import com.globalexchange.app.repository.LodgingDAO;
import com.globalexchange.app.repository.MeetDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LodgingObjectificationService implements LodgingService {
    private final LodgingDAO lodgingDAO;
    private final FileDAO fileDAO;

    // 숙소가 필요해 리스트
    @Override
    public List<LodgingVO> lodgingSelectAll(Criteria criteria) {
        return lodgingDAO.lodgingSelectAll(criteria);
    }


    // 리스트 전체 갯수
    @Override
    public int getTotal(){
        return  lodgingDAO.getTotal();
    }


    // 리스트 카테고리
    @Override
    public List<LodgingVO> categoryLodgingSelectAll(Criteria criteria,String lodgingLearningLang){
        return lodgingDAO.categoryLodgingSelectAll(criteria,lodgingLearningLang);
    }


    // 카테고리 게시글 전체 갯수
    @Override
    public int categoryGetTotal(String lodgingLearningLang){
        return lodgingDAO.categoryGetTotal(lodgingLearningLang);
    }
    /*




    @Override
    public List<MeetVO> categoryMeetSelectAll(Criteria criteria, String meetLearningLang) {
        return meetDAO.categoryMeetSelectAll(criteria, meetLearningLang);
    }

    @Override
    public int getTotal() {
        return meetDAO.getTotal();
    }

    @Override
    public int categoryGetTotal(String meetLearningLang) {
        return meetDAO.categoryGetTotal(meetLearningLang);
    }

    //작성자 정보 가져오기
    @Override
    public MemberVO writerInfo(Long memberNumber) {
        return meetDAO.writerInfo(memberNumber);
    }

    //작성자 프로필이미지 가져오기
    @Override
    public FileProfileVO getMeetWriterImage(Long memberNumber) {
        return fileDAO.getMeetWriterImage(memberNumber);
    }

    //meet 게시글 등록
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertMeetBody(MeetDTO meetDTO) {
        meetDAO.insertRequest(meetDTO);
        FileMeetVO file = meetDTO.getFileMeetVO();
//        Optional : 검증
        Optional.ofNullable(file).ifPresent(file1 -> {
            file1.setMeetNumber(meetDTO.getMeetNumber());
            fileDAO.insertMeetFile(file1);

        });
    }

    // meet 게시글 detail 정보 불러오기
    @Override
    public MeetDTO detailMeetBody(Long meetNumber) {
        MeetVO meetVO = meetDAO.selectMeetRequest(meetNumber);
        FileMeetVO fileMeetVO = fileDAO.getMeetFile(meetNumber);

        MemberVO memberVO = meetDAO.writerInfo(meetVO.getMemberNumber());
        FileProfileVO fileProfileVO = fileDAO.getMeetWriterImage(meetVO.getMemberNumber());
        log.info("" + memberVO);
        log.info("" + meetVO);
        MeetDTO meetDTO = new MeetDTO();
        meetDTO.setMeetNumber(meetNumber);
        meetDTO.setMeetTitle(meetVO.getMeetTitle());
        meetDTO.setMemberNumber(meetVO.getMemberNumber());
        meetDTO.setMeetLearningLang(meetVO.getMeetLearningLang());
        meetDTO.setMeetContent(meetVO.getMeetContent());
        meetDTO.setMeetWriteDate(meetVO.getMeetWriteDate());
        meetDTO.setMeetUpdateDate(meetVO.getMeetUpdateDate());
        meetDTO.setMeetAddress(meetVO.getMeetAddress());
        meetDTO.setMeetDetailAddress(meetVO.getMeetDetailAddress());

        meetDTO.setMemberTeachingLang(memberVO.getMemberTeachingLang());
        meetDTO.setMemberNickname(memberVO.getMemberNickname());

        meetDTO.setFileMeetVO(fileMeetVO);
        meetDTO.setFileProfileVO(fileProfileVO);

        log.info("" + meetDTO);
        return meetDTO;
    }

    //meet 게시글 수정페이지에서 글과 작성자 정보 불러오기
    @Override
    public MeetDTO goModifyPage(Long meetNumber) {
        MeetVO meetVO = meetDAO.selectMeetRequest(meetNumber);

        MemberVO memberVO = meetDAO.writerInfo(meetVO.getMemberNumber());
        FileProfileVO fileProfileVO = fileDAO.getMeetWriterImage(meetVO.getMemberNumber());

        MeetDTO meetDTO = new MeetDTO();
        meetDTO.setMeetNumber(meetNumber);
        meetDTO.setMeetTitle(meetVO.getMeetTitle());
        meetDTO.setMemberNumber(meetVO.getMemberNumber());
        meetDTO.setMeetLearningLang(meetVO.getMeetLearningLang());
        meetDTO.setMeetContent(meetVO.getMeetContent());
        meetDTO.setMeetAddress(meetVO.getMeetAddress());
        meetDTO.setMeetDetailAddress(meetVO.getMeetDetailAddress());

        meetDTO.setMemberTeachingLang(memberVO.getMemberTeachingLang());
        meetDTO.setMemberNickname(memberVO.getMemberNickname());

        meetDTO.setFileProfileVO(fileProfileVO);

        return meetDTO;
    }

    //meet 게시글 수정완료해서 글은 디비에 넣고, 원래있던 디비파일정보삭제하고(수정페이지에 원래있던 파일정보를 주는게 아니라서 파일번호모름) 디비파일정보 새로 넣음
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateMeetBody(MeetDTO meetDTO) {
        meetDAO.updateRequest(meetDTO);
        fileDAO.deleteMeetFile(meetDTO.getMeetNumber());

        FileMeetVO file = meetDTO.getFileMeetVO();
//        Optional : 검증
        Optional.ofNullable(file).ifPresent(file1 -> {
            file1.setMeetNumber(meetDTO.getMeetNumber());
            fileDAO.insertMeetFile(file1);

        });
    }

    //meet 게시글 삭제
    @Override
    public void deleteMeetBody(Long meetNumber) {
        meetDAO.deleteRequest(meetNumber);
    }

    //meet 답글 목록 보여주면서 페이지네이션
    @Override
    public List<MeetAnswerDTO> meetAnswerSelectAll(Long meetNumber, Criteria criteria) {
        List<MeetAnswerVO> meetAnswerVOList = meetDAO.meetAnswerSelectAll(meetNumber, criteria);
        List<MeetAnswerDTO> meetAnswerDTOList = new ArrayList<>();
        meetAnswerVOList.forEach(meetAnswerVO -> {
            MemberVO memberVO = meetDAO.writerInfo(meetAnswerVO.getMemberNumber());
            FileProfileVO fileProfileVO = fileDAO.getMeetWriterImage(meetAnswerVO.getMemberNumber());

            MeetAnswerDTO meetAnswerDTO = new MeetAnswerDTO();
            meetAnswerDTO.setMemberNumber(memberVO.getMemberNumber());
            meetAnswerDTO.setMemberNickname(memberVO.getMemberNickname());
            meetAnswerDTO.setMeetNumber(meetAnswerVO.getMeetNumber());
            meetAnswerDTO.setMeetAnswerWriteDate(meetAnswerVO.getMeetAnswerWriteDate());
            meetAnswerDTO.setMeetAnswerUpdateDate(meetAnswerVO.getMeetAnswerUpdateDate());
            meetAnswerDTO.setMeetAnswerNumber(meetAnswerVO.getMeetAnswerNumber());
            meetAnswerDTO.setMeetAnswerContent(meetAnswerVO.getMeetAnswerContent());
            if (fileProfileVO != null) {
                meetAnswerDTO.setFileImageCheck(fileProfileVO.isFileImageCheck());
                meetAnswerDTO.setFileName(fileProfileVO.getFileName());
                meetAnswerDTO.setFileUuid(fileProfileVO.getFileUuid());
                meetAnswerDTO.setFileUploadPath(fileProfileVO.getFileUploadPath());
                meetAnswerDTO.setFileSize(fileProfileVO.getFileSize());
                meetAnswerDTO.setFileNumber(fileProfileVO.getFileNumber());
            }

           *//* meetAnswerDTO.setFileImageCheck(fileProfileVO.isFileImageCheck());
            meetAnswerDTO.setFileName(fileProfileVO.getFileName());
            meetAnswerDTO.setFileUuid(fileProfileVO.getFileUuid());
            meetAnswerDTO.setFileUploadPath(fileProfileVO.getFileUploadPath());
            meetAnswerDTO.setFileSize(fileProfileVO.getFileSize());
            meetAnswerDTO.setFileNumber(fileProfileVO.getFileNumber());*//*
            else{
                meetAnswerDTO.setFileImageCheck(false);
                meetAnswerDTO.setFileName(null);
                meetAnswerDTO.setFileUuid(null);
                meetAnswerDTO.setFileUploadPath(null);
                meetAnswerDTO.setFileSize(null);
                meetAnswerDTO.setFileNumber(null);
            }


            meetAnswerDTOList.add(meetAnswerDTO);
        });

        return meetAnswerDTOList;
    }

    //meet 답글 갯수 세기
    @Override
    public long meetAnswerCount(Long meetNumber) {
        return meetDAO.meetAnswerCount(meetNumber);
    }
    //meet 답글 업데이트
    @Override
    public void  meetAnswerUpdate(MeetAnswerVO meetAnswerVO){
        meetDAO.meetAnswerUpdate(meetAnswerVO);
    }
    //meet 답글 쓰기 인서트
    @Override
    public void meetAnswerInsert(MeetAnswerVO meetAnswerVO){
        meetDAO.meetAnswerInsert(meetAnswerVO);
    }
    //meet 답글 코멘트 전체 불러오기
    @Override
    public List<MeetAnswerCommentDTO> meetAnswerCommentSelectAll(Long meetAnswerNumber) {
        List<MeetAnswerCommentVO> meetAnswerCommentVOList = meetDAO.meetAnswerCommentSelectAll(meetAnswerNumber);
        List<MeetAnswerCommentDTO> meetAnswerCommentDTOList = new ArrayList<>();
        log.info(""+meetAnswerCommentVOList);
        meetAnswerCommentVOList.forEach(meetAnswerCommentVO -> {
            MemberVO memberVO = meetDAO.writerInfo(meetAnswerCommentVO.getMemberNumber());
            FileProfileVO fileProfileVO = fileDAO.getMeetWriterImage(meetAnswerCommentVO.getMemberNumber());

            MeetAnswerCommentDTO meetAnswerCommentDTO = new MeetAnswerCommentDTO();

            meetAnswerCommentDTO.setMemberNumber(memberVO.getMemberNumber());
            meetAnswerCommentDTO.setMemberNickname(memberVO.getMemberNickname());
            meetAnswerCommentDTO.setMeetCommentWriteDate(meetAnswerCommentVO.getMeetCommentWriteDate());
            meetAnswerCommentDTO.setMeetCommentUpdateDate(meetAnswerCommentVO.getMeetCommentUpdateDate());
            meetAnswerCommentDTO.setMeetAnswerNumber(meetAnswerCommentVO.getMeetAnswerNumber());
            meetAnswerCommentDTO.setMeetAnswerCommentNumber(meetAnswerCommentVO.getMeetAnswerCommentNumber());
            meetAnswerCommentDTO.setMeetAnswerCommentContent(meetAnswerCommentVO.getMeetAnswerCommentContent());
            if (fileProfileVO != null) {
                meetAnswerCommentDTO.setFileImageCheck(fileProfileVO.isFileImageCheck());
                meetAnswerCommentDTO.setFileName(fileProfileVO.getFileName());
                meetAnswerCommentDTO.setFileUuid(fileProfileVO.getFileUuid());
                meetAnswerCommentDTO.setFileUploadPath(fileProfileVO.getFileUploadPath());
                meetAnswerCommentDTO.setFileSize(fileProfileVO.getFileSize());
                meetAnswerCommentDTO.setFileNumber(fileProfileVO.getFileNumber());
            }
            else{
                meetAnswerCommentDTO.setFileImageCheck(false);
                meetAnswerCommentDTO.setFileName(null);
                meetAnswerCommentDTO.setFileUuid(null);
                meetAnswerCommentDTO.setFileUploadPath(null);
                meetAnswerCommentDTO.setFileSize(null);
                meetAnswerCommentDTO.setFileNumber(null);
            }



            meetAnswerCommentDTOList.add(meetAnswerCommentDTO);
        });
        return meetAnswerCommentDTOList;
    }

    //meet 답글 삭제
    @Override
    public void meetAnswerRemove(Long meetAnswerNumber){
        meetDAO.meetAnswerRemove(meetAnswerNumber);
    }

    //meet 댓글 코멘트 등록
    @Override
    public void meetCommentInsert(MeetAnswerCommentVO meetAnswerCommentVO){
         meetDAO.meetCommentInsert(meetAnswerCommentVO);
    }
    //meet 댓글 코멘트 업데이트
    public void meetCommentUpdate(MeetAnswerCommentVO meetAnswerCommentVO){
        meetDAO.meetCommentUpdate(meetAnswerCommentVO);
    }
    //meet 댓글 코멘트 삭제
    public void meetCommentRemove(Long meetAnswerCommentNumber){
        meetDAO.meetCommentRemove(meetAnswerCommentNumber);
    }*/
}
