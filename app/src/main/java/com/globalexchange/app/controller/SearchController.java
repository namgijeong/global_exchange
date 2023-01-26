package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.PageDTO;
import com.globalexchange.app.domain.vo.PostDTO;
import com.globalexchange.app.service.SearchObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/search/*")
public class SearchController {

    public final SearchObjectificationService searchObjectificationService;
    // 게시글 검색 결과 목록 페이지
    @RequestMapping("/list")
    public void list (String searchKeyWord, Model model){
        //다른 게시판에서 criteria를 썼어도 이곳에 올때는 criteria 정보를 안넘기니까 어짜피 없는거나 마찬가지-> 이 검색결과에 와서 criteria 만들기
        Criteria criteria = new Criteria();
            criteria.create(1, 8);


        List<PostDTO> postDTOListInMeet= searchObjectificationService.searchKeyWordSelectAllInMeet(criteria,searchKeyWord);
        List<PostDTO> postDTOListInLodging= searchObjectificationService.searchKeyWordSelectAllInLodging(criteria,searchKeyWord);

       /* PageDTO pageDTOInMeet = new PageDTO().createPageDTO(criteria,searchObjectificationService.searchInPostsCountInMeet(searchKeyWord));
        PageDTO pageDTOInLodging = new PageDTO().createPageDTO(criteria,searchObjectificationService.searchInPostsCountInLodging(searchKeyWord));*/

        model.addAttribute("boardsInMeet",postDTOListInMeet);
        model.addAttribute("boardsInLodging",postDTOListInLodging);
       /* model.addAttribute("paginationInMeet",pageDTOInMeet);
        model.addAttribute("paginationInLodging",pageDTOInLodging);*/
        model.addAttribute("searchKeyWord",searchKeyWord);

    }

    // 게시글 검색 결과 만남과 도움 전체보기 목록 페이지
    @RequestMapping("/listInMeet")
    public String listInMeet(Criteria criteria, String searchKeyWord, Model model){
        //다른 게시판에서 criteria를 썼어도 이곳에 올때는 criteria 정보를 안넘기니까 어짜피 없는거나 마찬가지-> 이 검색결과에 와서 criteria 만들기
        if(criteria.getPage() == 0){
            criteria.create(1, 16);
        }

        List<PostDTO> postDTOListInMeet= searchObjectificationService.searchKeyWordSelectAllInMeet(criteria,searchKeyWord);

        PageDTO pageDTOInMeet = new PageDTO().createPageDTO(criteria,searchObjectificationService.searchInPostsCountInMeet(searchKeyWord));

        model.addAttribute("boardsInMeet",postDTOListInMeet);
        model.addAttribute("pagination",pageDTOInMeet);
        model.addAttribute("searchKeyWord",searchKeyWord);

        return "/search/listInMeet";

    }


    // 게시글 검색 결과 숙소가 필요해 전체보기 목록 페이지
    @RequestMapping("/listInLodging")
    public String listInLodging(Criteria criteria, String searchKeyWord, Model model){
        //다른 게시판에서 criteria를 썼어도 이곳에 올때는 criteria 정보를 안넘기니까 어짜피 없는거나 마찬가지-> 이 검색결과에 와서 criteria 만들기
        if(criteria.getPage() == 0){
            criteria.create(1, 16);
        }
        log.info("페이지네이션테스트"+criteria);
        log.info("페이지네이션테스트"+searchKeyWord);
        List<PostDTO> postDTOListInLodging= searchObjectificationService.searchKeyWordSelectAllInLodging(criteria,searchKeyWord);

        PageDTO pageDTOInLodging = new PageDTO().createPageDTO(criteria,searchObjectificationService.searchInPostsCountInLodging(searchKeyWord));


        model.addAttribute("boardsInLodging",postDTOListInLodging);
        model.addAttribute("pagination",pageDTOInLodging);
        model.addAttribute("searchKeyWord",searchKeyWord);

        return "/search/listInLodging";
    }
}
