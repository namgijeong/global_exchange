package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.repository.DiaryDAO;
import com.globalexchange.app.repository.FileDAO;
import com.globalexchange.app.repository.MemberDAO;
import com.globalexchange.app.repository.MemberReportDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor @Qualifier("diary") @Primary
public class DiaryObjectificationService implements DiaryService {

  private final DiaryDAO diaryDAO;
  private final FileDAO fileDAO;
  private final MemberDAO memberDAO;
  private final MemberReportDAO memberReportDAO;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void register(DiaryDTO diaryDTO) {
    diaryDAO.save(diaryDTO);
    FileDiaryVO fileDiaryVO = diaryDTO.getFileDiaryVO();
    Optional.ofNullable(fileDiaryVO).ifPresent(file -> {
      file.setDiaryNumber(diaryDTO.getDiaryNumber());
      fileDAO.diarySave(file);
    });
  }

  @Override
  public void modify(DiaryDTO diaryDTO) {
    diaryDAO.setDiaryVO(diaryDTO);
    fileDAO.diaryRemove(diaryDTO.getDiaryNumber());
    FileDiaryVO fileDiaryVO = diaryDTO.getFileDiaryVO();
    Optional.ofNullable(fileDiaryVO).ifPresent(file -> {
      file.setDiaryNumber(diaryDTO.getDiaryNumber());
      fileDAO.diarySave(file);
    });
  }

  @Override
  public void remove(Long diaryNumber) {
    fileDAO.diaryRemove(diaryNumber);
    diaryDAO.remove(diaryNumber);
  }

  @Override
  public DiaryDTO show(Long diaryNumber) {
    DiaryDTO diaryDTO = new DiaryDTO();
    diaryDTO.create(diaryDAO.findById(diaryNumber));
    diaryDTO.setFileDiaryVO(fileDAO.diaryFind(diaryNumber));
    diaryDTO.setDiaryPartnerNickname(memberDAO.diaryPartnerNickname(diaryDTO.getDiaryPartnerNumber()).getMemberNickname());
    diaryDTO.setFilePartnerProfileVO(memberDAO.myPageProfile(diaryDTO.getDiaryPartnerNumber()));
    diaryDTO.setMemberNationUrl(memberDAO.myPageDetail(diaryDTO.getDiaryPartnerNumber()).getMemberNationUrl());
    diaryDTO.setMemberTeachingLang(memberDAO.myPageDetail(diaryDTO.getDiaryPartnerNumber()).getMemberTeachingLang());
    return diaryDTO;
  }

  @Override
  public DiaryDTO showWrittenByPartner(Long diaryNumber) {
    DiaryDTO diaryDTO = new DiaryDTO();
    diaryDTO.create(diaryDAO.findById(diaryNumber));
    diaryDTO.setFileDiaryVO(fileDAO.diaryFind(diaryNumber));
    diaryDTO.setDiaryPartnerNickname(memberDAO.diaryPartnerNickname(diaryDTO.getMemberNumber()).getMemberNickname());
    diaryDTO.setFilePartnerProfileVO(memberDAO.myPageProfile(diaryDTO.getMemberNumber()));
    diaryDTO.setMemberNationUrl(memberDAO.myPageDetail(diaryDTO.getMemberNumber()).getMemberNationUrl());
    diaryDTO.setMemberTeachingLang(memberDAO.myPageDetail(diaryDTO.getMemberNumber()).getMemberTeachingLang());
    return diaryDTO;
  }


  @Override
  public List<DiaryDTO> showAll(Criteria criteria) {
    List<DiaryDTO> list = diaryDAO.findAll(criteria);
    List<DiaryDTO> list2 = new ArrayList<>();

    log.info("list: "+list);
    for(DiaryDTO diaryDTO : list) {
      {
        diaryDTO.create(diaryDAO.findById(diaryDTO.getDiaryNumber()));
        log.info("diaryDTO1:"+diaryDTO);

        diaryDTO.setFileDiaryVO(fileDAO.diaryFind(diaryDTO.getDiaryNumber()));
        log.info("diaryDTO2:"+diaryDTO);
        diaryDTO.setDiaryPartnerNickname(memberDAO.diaryPartnerNickname(diaryDTO.getDiaryPartnerNumber()).getMemberNickname());
        log.info("diaryDTO3:"+diaryDTO);
        diaryDTO.setFilePartnerProfileVO(memberDAO.myPageProfile(diaryDTO.getDiaryPartnerNumber()));
        list2.add(diaryDTO);

      }
    }
    log.info("list2: " + list2);
    return list2;

  }

  @Override
  public List<DiaryDTO> myDiarySelectAll(Criteria criteria, Long memberNumber){
    List<DiaryDTO> list = diaryDAO.myDiarySelectAll(criteria, memberNumber);
    List<DiaryDTO> list2 = new ArrayList<>();

    for(DiaryDTO diaryDTO : list) {
      {
        diaryDTO.create(diaryDAO.findById(diaryDTO.getDiaryNumber()));
        diaryDTO.setFileDiaryVO(fileDAO.diaryFind(diaryDTO.getDiaryNumber()));
        diaryDTO.setDiaryPartnerNickname(memberDAO.diaryPartnerNickname(diaryDTO.getDiaryPartnerNumber()).getMemberNickname());
        log.info("내가쓴일기의 파트너:"+memberDAO.diaryPartnerNickname(diaryDTO.getDiaryPartnerNumber()).getMemberNickname());
        diaryDTO.setFilePartnerProfileVO(memberDAO.myPageProfile(diaryDTO.getDiaryPartnerNumber()));
        list2.add(diaryDTO);
      }
    }
    return list2;
  }

  @Override
  public List<DiaryDTO> myPartnerSelectAll(Long memberNumber, Long diaryPartnerNumber, Criteria criteria){
    List<DiaryDTO> list = diaryDAO.myPartnerSelectAll(memberNumber, diaryPartnerNumber, criteria);
    List<DiaryDTO> list2 = new ArrayList<>();

    for(DiaryDTO diaryDTO : list) {
      {
        diaryDTO.create(diaryDAO.findById(diaryDTO.getDiaryNumber()));

        diaryDTO.setFileDiaryVO(fileDAO.diaryFind(diaryDTO.getDiaryNumber()));
        diaryDTO.setDiaryPartnerNickname(memberDAO.diaryPartnerNickname(diaryDTO.getDiaryPartnerNumber()).getMemberNickname());
        diaryDTO.setFilePartnerProfileVO(memberDAO.myPageProfile(diaryDTO.getDiaryPartnerNumber()));
        list2.add(diaryDTO);

      }
    }
    return list2;
  }

  @Override
  public List<DiaryDTO> toMeDiarySelectAll(Criteria criteria, Long memberNumber){
    List<DiaryDTO> list = diaryDAO.toMeDiarySelectAll(criteria, memberNumber);
    List<DiaryDTO> list2 = new ArrayList<>();

    for(DiaryDTO diaryDTO : list) {
      {
        diaryDTO.create(diaryDAO.findById(diaryDTO.getDiaryNumber()));
        diaryDTO.setFileDiaryVO(fileDAO.diaryFind(diaryDTO.getDiaryNumber()));
        diaryDTO.setDiaryPartnerNickname(memberDAO.diaryPartnerNickname(diaryDTO.getMemberNumber()).getMemberNickname());
        log.info("파트너가 쓴 일기의 파트너:"+memberDAO.diaryPartnerNickname(diaryDTO.getMemberNumber()).getMemberNickname());
        diaryDTO.setFilePartnerProfileVO(memberDAO.myPageProfile(diaryDTO.getMemberNumber()));
        list2.add(diaryDTO);
      }
    }
    return list2;
  }

  @Override
  public List<DiaryDTO> toMeFromPartnerDiarySelectAll(Criteria criteria, Long memberNumber, Long diaryPartnerNumber){
    List<DiaryDTO> list = diaryDAO.toMeFromPartnerDiarySelectAll(criteria, memberNumber, diaryPartnerNumber);
    List<DiaryDTO> list2 = new ArrayList<>();

    for(DiaryDTO diaryDTO : list) {
      {
        diaryDTO.create(diaryDAO.findById(diaryDTO.getDiaryNumber()));
        diaryDTO.setFileDiaryVO(fileDAO.diaryFind(diaryDTO.getDiaryNumber()));
        diaryDTO.setDiaryPartnerNickname(memberDAO.diaryPartnerNickname(diaryDTO.getMemberNumber()).getMemberNickname());
        diaryDTO.setFilePartnerProfileVO(memberDAO.myPageProfile(diaryDTO.getMemberNumber()));
        list2.add(diaryDTO);
      }
    }
    return list2;
  }

  @Override
  public int getTotal() {
    return diaryDAO.findCountAll();
  }

  @Override
  public int myDiaryGetTotal(Long memberNumber){
    return diaryDAO.myDiaryGetTotal(memberNumber);
  }

  @Override
  public int categoryGetTotal(Long memberNumber, Long diaryPartnerNumber) {
    return diaryDAO.categoryGetTotal(memberNumber, diaryPartnerNumber);
  }

  @Override
  public int toMeDiaryGetTotal(Long memberNumber){
    return diaryDAO.toMeDiaryGetTotal(memberNumber);
  }

  @Override
  public int toMeFromPartnerDiaryGetTotal(Long memberNumber, Long diaryPartnerNumber){
    return diaryDAO.toMeFromPartnerDiaryGetTotal(memberNumber, diaryPartnerNumber);
  }

  @Override
  public List<MemberDTO> showAllPartner(Criteria criteria) {
    List<MemberVO> memberVOList = memberDAO.findAll(criteria);
    List<MemberDTO> memberDTOList = new ArrayList<>();

    for(MemberVO memberVO : memberVOList){
      MemberDTO memberDTO = new MemberDTO();

      memberDTO.create(memberVO);
      memberDTO.setFileProfileVO(memberDAO.myPageProfile(memberVO.getMemberNumber()));

      memberDTOList.add(memberDTO);
    }

    return memberDTOList;
  }

  @Override
  public int getTotal(Criteria criteria) {
    return memberDAO.findCountAll(criteria);
  }

  @Override
  public List<MemberDTO> showPartner(Long memberNumber){
//    List<Long> memberVOList = diaryDAO.findPartner(memberNumber);
//    log.info("memberNumber:"+memberNumber);
//    log.info("memberVOList:"+memberVOList);
//    List<MemberDTO> memberDTOList = new ArrayList<>();
//
//    for(MemberVO memberVO : memberVOList){
//      MemberDTO memberDTO = new MemberDTO();
//
//      memberDTO.create2(memberVO);
//      memberDTO.setFileProfileVO(memberDAO.myPageProfile(memberVO.getMemberNumber()));
//
//      memberDTOList.add(memberDTO);
//    }

//    return memberDTOList;
    List<Long> memberNumberList = diaryDAO.findPartner(memberNumber);
    List<MemberDTO> memberDTOList = new ArrayList<>();
    for(Long memberVO : memberNumberList){
      MemberDTO memberDTO = new MemberDTO();
//      memberVO1.setMemberNickname(memberDAO.diaryPartnerNickname(memberNumber).getMemberNickname());
//      memberVOList.add(memberVO1);
      memberDTO.create(memberDAO.diaryPartnerNickname(memberVO));
      memberDTOList.add(memberDTO);
    }

    return memberDTOList;


  }

  @Override
  public MemberDTO showPartnerDetail(Long memberNumber) {

    MemberDTO memberDTO = new MemberDTO();
    memberDTO.create(memberDAO.findByMemberNumber(memberNumber), memberDAO.myPageProfile(memberNumber)
            , memberDAO.diaryTotalPost(memberNumber), (memberDAO.meetPost(memberNumber) + memberDAO.lodgingPost(memberNumber))
            , (memberDAO.meetAnswer(memberNumber) + memberDAO.lodgingAnswer(memberNumber)));

    return memberDTO;
  }

  @Override
  public void registerPartner(Long memberNumber, Long diaryPartnerNumber) {
    diaryDAO.saveDiaryPartner(memberNumber, diaryPartnerNumber);
  }

  @Override
  public int diaryPartnerCheck(Long memberNumber, Long diaryPartnerNumber) {
    return diaryDAO.diaryPartnerCheck(memberNumber, diaryPartnerNumber);
  }

  @Override
  public void registerReport(Long reportingMemberNumber, Long reportedMemberNumber) {
    memberReportDAO.saveReport(reportingMemberNumber, reportedMemberNumber);
  }

  @Override
  public List<DiaryCommentDTO> diaryCommentSelectAll(Criteria criteria, Long diaryNumber){
    List<DiaryCommentVO> diaryCommentVOList = diaryDAO.diaryCommentSelectAll(criteria, diaryNumber);
    List<DiaryCommentDTO> diaryCommentDTOList = new ArrayList<>();
    diaryCommentVOList.forEach(diaryCommentVO -> {
      MemberVO memberVO = memberDAO.findByMemberNumber(diaryCommentVO.getMemberNumber());
      FileProfileVO fileProfileVO = memberDAO.myPageProfile(diaryCommentVO.getMemberNumber());

      DiaryCommentDTO diaryCommentDTO = new DiaryCommentDTO();
      diaryCommentDTO.setMemberNumber(diaryCommentVO.getMemberNumber());
      diaryCommentDTO.setMemberNickname(memberVO.getMemberNickname());
      diaryCommentDTO.setDiaryNumber(diaryCommentVO.getDiaryNumber());
      diaryCommentDTO.setDiaryCommentNumber(diaryCommentVO.getDiaryCommentNumber());
      diaryCommentDTO.setDiaryCommentContent(diaryCommentVO.getDiaryCommentContent());
      diaryCommentDTO.setDiaryCommentWriteDate(diaryCommentVO.getDiaryCommentWriteDate());
      diaryCommentDTO.setDiaryCommentUpdateDate(diaryCommentVO.getDiaryCommentUpdateDate());

      if(fileProfileVO != null){
        diaryCommentDTO.setFileImageCheck(fileProfileVO.isFileImageCheck());
        diaryCommentDTO.setFileNumber(fileProfileVO.getFileNumber());
        diaryCommentDTO.setFileName(fileProfileVO.getFileName());
        diaryCommentDTO.setFileUploadPath(fileProfileVO.getFileUploadPath());
        diaryCommentDTO.setFileUuid(fileProfileVO.getFileUuid());
        diaryCommentDTO.setFileSize(fileProfileVO.getFileSize());
      }
      else{
        diaryCommentDTO.setFileImageCheck(false);
        diaryCommentDTO.setFileNumber(null);
        diaryCommentDTO.setFileName(null);
        diaryCommentDTO.setFileUploadPath(null);
        diaryCommentDTO.setFileUuid(null);
        diaryCommentDTO.setFileSize(null);
      }

      diaryCommentDTOList.add(diaryCommentDTO);
    });
    return diaryCommentDTOList;
  }

  @Override
  public int diaryCommentCount(Long diaryNumber){
    return diaryDAO.diaryCommentCount(diaryNumber);
  }

  @Override
  public void diaryCommentInsert(DiaryCommentVO diaryCommentVO){
    diaryDAO.diaryCommentInsert(diaryCommentVO);
  }

  @Override
  public void diaryCommentUpdate(DiaryCommentVO diaryCommentVO){
    diaryDAO.diaryCommentUpdate(diaryCommentVO);
  }

  @Override
  public void diaryCommentDelete(Long diaryCommentNumber){
    diaryDAO.diaryCommentDelete(diaryCommentNumber);
  }
}
