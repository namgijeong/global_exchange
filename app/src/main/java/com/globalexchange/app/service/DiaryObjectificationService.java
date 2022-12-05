package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.repository.DiaryDAO;
import com.globalexchange.app.repository.FileDAO;
import com.globalexchange.app.repository.MemberDAO;
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
        log.info("diaryNumber;"+diaryDTO.getDiaryNumber());

        diaryDTO.setFileDiaryVO(fileDAO.diaryFind(diaryDTO.getDiaryNumber()));
        log.info("diaryDTO:"+diaryDTO);
        list2.add(diaryDTO);

      }
    }
    log.info("list2: " + list2);
    return list2;

  }

  @Override
  public int getTotal() {
    return diaryDAO.findCountAll();
  }

  @Override
  public List<MemberDTO> showAllPartner(Criteria criteria) {
    List<MemberVO> memberVOList = memberDAO.findAll(criteria);
    List<MemberDTO> memberDTOList = new ArrayList<>();

    for(MemberVO memberVO : memberVOList){
      MemberDTO memberDTO = new MemberDTO();

      memberDTO.create2(memberVO);
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
  public MemberDTO showPartner(Long memberNumber) {

    MemberDTO memberDTO = new MemberDTO();
    memberDTO.create(memberDAO.findByMemberNumber(memberNumber), memberDAO.myPageProfile(memberNumber)
            , memberDAO.diaryTotalPost(memberNumber), (memberDAO.meetPost(memberNumber) + memberDAO.lodgingPost(memberNumber))
            , (memberDAO.meetAnswer(memberNumber) + memberDAO.lodgingAnswer(memberNumber)));

    return memberDTO;
  }
}
