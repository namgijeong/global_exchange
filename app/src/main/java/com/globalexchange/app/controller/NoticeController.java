package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.PageDTO;
import com.globalexchange.app.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/*")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    // 공지사항 리스트 페이지 이동
    @GetMapping("/list")
    public void notice(Criteria criteria, Model model){

        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }

        model.addAttribute("notices", noticeService.showAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, noticeService.getTotal()));
    }

}
