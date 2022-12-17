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
@RequestMapping("/needLodgingComment/*")
@RequiredArgsConstructor
@Slf4j
public class NeedLodgingCommentController {
    private final LodgingObjectificationService lodgingObjectificationService;

    // 숙소가 필요해 댓글 작성 완료
    @GetMapping("/list/{lodgingAnswerNumber}")
    public List<LodgingAnswerCommentDTO> answerCommentWrite(@PathVariable("lodgingAnswerNumber") Long lodgingAnswerNumber){
        List<LodgingAnswerCommentDTO> lodgingAnswerCommentDTOList = lodgingObjectificationService.lodgingAnswerCommentSelectAll(lodgingAnswerNumber);

        log.info("코멘트 리스트"+ lodgingAnswerCommentDTOList);
        return lodgingAnswerCommentDTOList;
    }


    // 숙소가 필요해 댓글 작성 완료
    @PostMapping("/commentWriteOk")
    public void answerCommentWriteOk(@RequestBody LodgingAnswerCommentVO lodgingAnswerCommentVO,HttpServletRequest request){
        HttpSession session = request.getSession();
        Long memberNumber =(Long)session.getAttribute("memberNumber");

        lodgingAnswerCommentVO.setMemberNumber(memberNumber);
        lodgingObjectificationService.lodgingCommentInsert(lodgingAnswerCommentVO);
    }


    // 숙소가 필요해 댓글 수정 완료
    @PostMapping("/commentUpdateOk")
    public void answerCommentUpdateOk(@RequestBody LodgingAnswerCommentVO lodgingAnswerCommentVO){
        lodgingObjectificationService.lodgingCommentUpdate(lodgingAnswerCommentVO);
    }

    // 숙소가 필요해 댓글 삭제
    @GetMapping("/commentRemove/{lodgingAnswerCommentNumber}")
    public void answerCommentRemove(@PathVariable("lodgingAnswerCommentNumber") Long lodgingCommentNumber){
        lodgingObjectificationService.lodgingCommentRemove(lodgingCommentNumber);
    }
}
