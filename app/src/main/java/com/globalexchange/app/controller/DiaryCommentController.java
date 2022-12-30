package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.DiaryCommentDTO;
import com.globalexchange.app.domain.vo.DiaryCommentPagenationDTO;
import com.globalexchange.app.domain.vo.DiaryCommentVO;
import com.globalexchange.app.service.DiaryObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/diaryComment/*")
public class DiaryCommentController {
  private  final DiaryObjectificationService diaryObjectificationService;
  // 일기 코멘트 작성
//  @GetMapping("/commentWrite")
//  public void commentWrite(){
//
//  }

  // 일기 코멘트 리스트
  @GetMapping("/list/{diaryNumber}/{page}")
  public DiaryCommentPagenationDTO list(@PathVariable("diaryNumber") Long diaryNumber, @PathVariable int page){
    List<DiaryCommentDTO> diaryCommentDTOList = diaryObjectificationService.diaryCommentSelectAll(new Criteria().create(page, 2), diaryNumber);
    long diaryCommentCount = diaryObjectificationService.diaryCommentCount(diaryNumber);
    DiaryCommentPagenationDTO diaryCommentPagenationDTO = new DiaryCommentPagenationDTO();
    diaryCommentPagenationDTO.setDiaryCommentCount(diaryCommentCount);
    diaryCommentPagenationDTO.setDiaryCommentDTOList(diaryCommentDTOList);
    log.info("다이어리코멘트DTO리스트: "+diaryCommentDTOList);
    return diaryCommentPagenationDTO;
  }

  // 일기 코멘트 작성 완료
  @PostMapping("/commentWrite")
  public void commentWrite(@RequestBody DiaryCommentVO diaryCommentVO, HttpServletRequest request){
    HttpSession session = request.getSession();
    Long memberNumber = (Long)session.getAttribute("memberNumber");
    diaryCommentVO.setMemberNumber(memberNumber);
    diaryObjectificationService.diaryCommentInsert(diaryCommentVO);
  }

  // 일기 코멘트 수정 활성화
//  @GetMapping("/commentUpdate")
//  public void commentUpdate(){
//
//  }

  // 일기 코멘트 수정 완료
  @PostMapping("/commentUpdate")
  public void commentUpdate(@RequestBody DiaryCommentVO diaryCommentVO){
    diaryObjectificationService.diaryCommentUpdate(diaryCommentVO);
  }

  // 일기 코멘트 삭제
  @GetMapping("/commentRemove/{diaryCommentNumber}")
  public void CommentRemove(@PathVariable("diaryCommentNumber") Long diaryCommentNumber){
    diaryObjectificationService.diaryCommentDelete(diaryCommentNumber);
  }
}
