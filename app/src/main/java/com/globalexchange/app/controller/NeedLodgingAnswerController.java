package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.service.LodgingObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/needLodgingAnswer/*")
@RequiredArgsConstructor
@Slf4j
public class NeedLodgingAnswerController {
    private final LodgingObjectificationService lodgingObjectificationService;


    // 숙소가 필요해 답글 목록 pageNation
    @GetMapping("/list/{lodgingNumber}/{page}")
    public LodgingAnswerPagenationDTO list(@PathVariable("lodgingNumber") Long lodgingNumber, @PathVariable int page){
        log.info("답글 컨트롤러 들어옴!!!!!!!!!!!1");
        List<LodgingAnswerDTO> lodgingAnswerDTOList = lodgingObjectificationService.lodgingAnswerSelectAll(lodgingNumber, new Criteria().create(page,2));
        long lodgingAnswerCount = lodgingObjectificationService.lodgingAnswerCount(lodgingNumber);

        LodgingAnswerPagenationDTO lodgingAnswerPagenationDTO = new LodgingAnswerPagenationDTO();
        lodgingAnswerPagenationDTO.setLodgingAnswerCount(lodgingAnswerCount);
        lodgingAnswerPagenationDTO.setLodgingAnswerDTOList(lodgingAnswerDTOList);

        log.info("답글리스트"+lodgingAnswerPagenationDTO);

        return lodgingAnswerPagenationDTO;
    }

    // 숙소가 필요해 답글 수정 활성화
    @PostMapping("/answerWriteOk")
    public void answerWriteOk(@RequestBody LodgingAnswerVO lodgingAnswerVO, HttpServletRequest request){
        log.info("answerWriteOk컨트롤러 들어옴" + lodgingAnswerVO);
        HttpSession session = request.getSession();
        Long memberNumber = (Long)session.getAttribute("memberNumber");
        lodgingAnswerVO.setMemberNumber(memberNumber);
        lodgingObjectificationService.lodgingAnswerInsert(lodgingAnswerVO);
    }

    // 숙소가 필요해 답글 수정 완료
    @PostMapping("/answerUpdateOk")
    public void answerUpdateOk(@RequestBody LodgingAnswerVO lodgingAnswerVO){
        log.info("answerUpdateOk 수정완료 컨트롤러들어옴"+lodgingAnswerVO);
        lodgingObjectificationService.lodgingAnswerUpdate(lodgingAnswerVO);
    }

    // 숙소가 필요해 답글 삭제
    @GetMapping("/answerRemove/{lodgingAnswerNumber}")
    public void answerRemove(@PathVariable("lodgingAnswerNumber") Long lodgingAnswerNumber){
        lodgingObjectificationService.lodgingAnswerRemove(lodgingAnswerNumber);
    }


}
