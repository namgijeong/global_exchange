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

    // 숙소가 필요해 상세보기
    @Override
    public LodgingDTO detailLodgingBody(Long lodgingNumber){
        LodgingVO lodgingVO = lodgingDAO.selectLodgingRequest(lodgingNumber);
        FileLodgingVO fileLodgingVO = fileDAO.getLodgingFile(lodgingNumber);

        MemberVO memberVO = lodgingDAO.writerInfo(lodgingVO.getMemberNumber());
        FileProfileVO fileProfileVO = fileDAO.getLodgingWriterImage(lodgingVO.getMemberNumber());

        LodgingDTO lodgingDTO = new LodgingDTO();
        lodgingDTO.setLodgingNumber(lodgingNumber);
        lodgingDTO.setLodgingTitle(lodgingVO.getLodgingTitle());
        lodgingDTO.setMemberNumber(lodgingVO.getMemberNumber());
        lodgingDTO.setLodgingLearningLang(lodgingVO.getLodgingLearningLang());
        lodgingDTO.setLodgingContent(lodgingVO.getLodgingContent());
        lodgingDTO.setLodgingWriteDate(lodgingVO.getLodgingWriteDate());
        lodgingDTO.setLodgingUpdateDate(lodgingVO.getLodgingUpdateDate());
        lodgingDTO.setLodgingAddress(lodgingVO.getLodgingAddress());
        lodgingDTO.setLodgingDetailAddress(lodgingVO.getLodgingDetailAddress());

        lodgingDTO.setMemberTeachingLang(memberVO.getMemberTeachingLang());
        lodgingDTO.setMemberNickname(memberVO.getMemberNickname());

        lodgingDTO.setFileLodgingVO(fileLodgingVO);
        lodgingDTO.setFileProfileVO(fileProfileVO);
        return lodgingDTO;
    }




    //작성자 정보 가져오기
    @Override
    public MemberVO writerInfo(Long memberNumber) {
        return lodgingDAO.writerInfo(memberNumber);
    }

    //작성자 프로필이미지 가져오기
    @Override
    public FileProfileVO getMeetWriterImage(Long memberNumber) {
        return fileDAO.getMeetWriterImage(memberNumber);
    }

    //lodging 게시글 등록
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertLodgingBody(LodgingDTO lodgingDTO) {
        lodgingDAO.insertRequest(lodgingDTO);
        FileLodgingVO file = lodgingDTO.getFileLodgingVO();
//        Optional : 검증
        Optional.ofNullable(file).ifPresent(file1 -> {
            file1.setLodgingNumber(lodgingDTO.getLodgingNumber());
            fileDAO.insertLodgingFile(file1);

        });
    }


    //lodging 게시글 수정페이지에서 글과 작성자 정보 불러오기
    @Override
    public LodgingDTO goModifyPage(Long lodgingNumber){

            LodgingVO lodgingVO = lodgingDAO.selectLodgingRequest(lodgingNumber);

            MemberVO memberVO = lodgingDAO.writerInfo(lodgingVO.getMemberNumber());
            FileProfileVO fileProfileVO = fileDAO.getMeetWriterImage(lodgingVO.getMemberNumber());

        LodgingDTO lodgingDTO = new LodgingDTO();
        lodgingDTO.setLodgingNumber(lodgingNumber);
        lodgingDTO.setLodgingTitle(lodgingVO.getLodgingTitle());
        lodgingDTO.setMemberNumber(lodgingVO.getMemberNumber());
        lodgingDTO.setLodgingLearningLang(lodgingVO.getLodgingLearningLang());
        lodgingDTO.setLodgingContent(lodgingVO.getLodgingContent());
        lodgingDTO.setLodgingAddress(lodgingVO.getLodgingAddress());
        lodgingDTO.setLodgingDetailAddress(lodgingVO.getLodgingDetailAddress());

        lodgingDTO.setMemberTeachingLang(memberVO.getMemberTeachingLang());
        lodgingDTO.setMemberNickname(memberVO.getMemberNickname());

        lodgingDTO.setFileProfileVO(fileProfileVO);

            return lodgingDTO;

    }

    //lodging 게시글 수정완료해서 글은 디비에 넣고, 원래있던 디비파일정보삭제하고(수정페이지에 원래있던 파일정보를 주는게 아니라서 파일번호모름) 디비파일정보 새로 넣음
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateLodgingBody(LodgingDTO lodgingDTO) {
        lodgingDAO.updateRequest(lodgingDTO);
        fileDAO.deleteLodgingFile(lodgingDTO.getLodgingNumber());

        FileLodgingVO file = lodgingDTO.getFileLodgingVO();
//        Optional : 검증
        Optional.ofNullable(file).ifPresent(file1 -> {
            file1.setLodgingNumber(lodgingDTO.getLodgingNumber());
            fileDAO.insertLodgingFile(file1);

        });
    }

    // lodging 게시글 delete
    public void deleteRequest(Long lodgingNumber) {
        lodgingDAO.deleteRequest(lodgingNumber);

    }

    //meet 답글 목록 보여주면서 페이지네이션
    @Override
    public List<LodgingAnswerDTO> lodgingAnswerSelectAll(Long lodgingNumber, Criteria criteria) {
        List<LodgingAnswerVO> lodgingAnswerVOList = lodgingDAO.lodgingAnswerSelectAll(lodgingNumber, criteria);
        List<LodgingAnswerDTO> lodgingAnswerDTOList = new ArrayList<>();
        lodgingAnswerVOList.forEach(lodgingAnswerVO -> {
            MemberVO memberVO = lodgingDAO.writerInfo(lodgingAnswerVO.getMemberNumber());
            FileProfileVO fileProfileVO = fileDAO.getLodgingWriterImage(lodgingAnswerVO.getMemberNumber());

            LodgingAnswerDTO lodgingAnswerDTO = new LodgingAnswerDTO();
            lodgingAnswerDTO.setMemberNumber(memberVO.getMemberNumber());
            lodgingAnswerDTO.setMemberNickname(memberVO.getMemberNickname());
            lodgingAnswerDTO.setLodgingNumber(lodgingAnswerVO.getLodgingNumber());
            lodgingAnswerDTO.setLodgingAnswerWriteDate(lodgingAnswerVO.getLodgingAnswerWriteDate());
            lodgingAnswerDTO.setLodgingAnswerUpdateDate(lodgingAnswerVO.getLodgingAnswerUpdateDate());
            lodgingAnswerDTO.setLodgingAnswerNumber(lodgingAnswerVO.getLodgingAnswerNumber());
            lodgingAnswerDTO.setLodgingAnswerContent(lodgingAnswerVO.getLodgingAnswerContent());
            if (fileProfileVO != null) {
                lodgingAnswerDTO.setFileImageCheck(fileProfileVO.isFileImageCheck());
                lodgingAnswerDTO.setFileName(fileProfileVO.getFileName());
                lodgingAnswerDTO.setFileUuid(fileProfileVO.getFileUuid());
                lodgingAnswerDTO.setFileUploadPath(fileProfileVO.getFileUploadPath());
                lodgingAnswerDTO.setFileSize(fileProfileVO.getFileSize());
                lodgingAnswerDTO.setFileNumber(fileProfileVO.getFileNumber());
            }

            else{
                lodgingAnswerDTO.setFileImageCheck(false);
                lodgingAnswerDTO.setFileName(null);
                lodgingAnswerDTO.setFileUuid(null);
                lodgingAnswerDTO.setFileUploadPath(null);
                lodgingAnswerDTO.setFileSize(null);
                lodgingAnswerDTO.setFileNumber(null);
            }


            lodgingAnswerDTOList.add(lodgingAnswerDTO);
        });

        return lodgingAnswerDTOList;
    }

    // 숙소가 필요해 답글 갯수
    @Override
    public Long lodgingAnswerCount(Long lodgingNumber){
        return lodgingDAO.lodgingAnswerCount(lodgingNumber);
    }

    // 숙소가 필요해 답글 수정
    @Override
    public void lodgingAnswerUpdate(LodgingAnswerVO lodgingAnswerVO){
         lodgingDAO.lodgingAnswerUpdate(lodgingAnswerVO);
    }

    // 숙소가 필요해 답글 추가
    @Override
    public void lodgingAnswerInsert(LodgingAnswerVO lodgingAnswerVO){
         lodgingDAO.lodgingAnswerInsert(lodgingAnswerVO);
    }

    // 숙소가 필요해 답글 삭제
    @Override
    public void lodgingAnswerRemove(Long lodgingAnswerNumber){
        lodgingDAO.lodgingAnswerRemove(lodgingAnswerNumber);
    }
    
    //meet 답글 코멘트 전체 불러오기
    @Override
    public List<LodgingAnswerCommentDTO> lodgingAnswerCommentSelectAll(Long lodgingAnswerNumber) {
        List<LodgingAnswerCommentVO> lodgingAnswerCommentVOList = lodgingDAO.lodgingAnswerCommentSelectAll(lodgingAnswerNumber);
        List<LodgingAnswerCommentDTO> lodgingAnswerCommentDTOList = new ArrayList<>();
        log.info(""+lodgingAnswerCommentVOList);
        lodgingAnswerCommentVOList.forEach(lodgingAnswerCommentVO -> {
            MemberVO memberVO = lodgingDAO.writerInfo(lodgingAnswerCommentVO.getMemberNumber());
            FileProfileVO fileProfileVO = fileDAO.getMeetWriterImage(lodgingAnswerCommentVO.getMemberNumber());

            LodgingAnswerCommentDTO lodgingAnswerCommentDTO = new LodgingAnswerCommentDTO();

            lodgingAnswerCommentDTO.setMemberNumber(memberVO.getMemberNumber());
            lodgingAnswerCommentDTO.setMemberNickname(memberVO.getMemberNickname());
            lodgingAnswerCommentDTO.setLodgingCommentWriteDate(lodgingAnswerCommentVO.getLodgingCommentWriteDate());
            lodgingAnswerCommentDTO.setLodgingCommentUpdateDate(lodgingAnswerCommentVO.getLodgingCommentUpdateDate());
            lodgingAnswerCommentDTO.setLodgingAnswerNumber(lodgingAnswerCommentVO.getLodgingAnswerNumber());
            lodgingAnswerCommentDTO.setLodgingAnswerCommentNumber(lodgingAnswerCommentVO.getLodgingAnswerCommentNumber());
            lodgingAnswerCommentDTO.setLodgingAnswerCommentContent(lodgingAnswerCommentVO.getLodgingAnswerCommentContent());
            if (fileProfileVO != null) {
                lodgingAnswerCommentDTO.setFileImageCheck(fileProfileVO.isFileImageCheck());
                lodgingAnswerCommentDTO.setFileName(fileProfileVO.getFileName());
                lodgingAnswerCommentDTO.setFileUuid(fileProfileVO.getFileUuid());
                lodgingAnswerCommentDTO.setFileUploadPath(fileProfileVO.getFileUploadPath());
                lodgingAnswerCommentDTO.setFileSize(fileProfileVO.getFileSize());
                lodgingAnswerCommentDTO.setFileNumber(fileProfileVO.getFileNumber());
            }
            else{
                lodgingAnswerCommentDTO.setFileImageCheck(false);
                lodgingAnswerCommentDTO.setFileName(null);
                lodgingAnswerCommentDTO.setFileUuid(null);
                lodgingAnswerCommentDTO.setFileUploadPath(null);
                lodgingAnswerCommentDTO.setFileSize(null);
                lodgingAnswerCommentDTO.setFileNumber(null);
            }



            lodgingAnswerCommentDTOList.add(lodgingAnswerCommentDTO);
        });
        return lodgingAnswerCommentDTOList;
    }

    // lodging 댓글 추가
    @Override
    public void lodgingCommentInsert(LodgingAnswerCommentVO lodgingAnswerCommentVO){
        lodgingDAO.lodgingCommentInsert(lodgingAnswerCommentVO);
    }

    // lodging 댓글 수정
    public void lodgingCommentUpdate(LodgingAnswerCommentVO lodgingAnswerCommentVO){
        lodgingDAO.lodgingCommentUpdate(lodgingAnswerCommentVO);
    }

    // lodging 댓글 삭제
    public void lodgingCommentRemove(Long lodgingAnswerNumber){
        lodgingDAO.lodgingCommentRemove(lodgingAnswerNumber);
    }
}
