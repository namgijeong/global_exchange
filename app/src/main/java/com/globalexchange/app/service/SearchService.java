package com.globalexchange.app.service;

//import com.example.app.domain.vo.BoardDTO;
//import com.example.app.domain.vo.BoardVO;
//import com.example.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService {

    // meet 게시글에서 searchKeyWord가 포함된 제목 게시글 리스트 뽑기
    public List<PostDTO> searchKeyWordSelectAllInMeet(Criteria criteria, String searchKeyWord);

    // lodging 게시글에서 searchKeyWord가 포함된 제목 게시글 리스트 뽑기
    public List<PostDTO> searchKeyWordSelectAllInLodging(Criteria criteria, String searchKeyWord);

    /*//meet +  lodging 게시글에서 searchKeyWord가 포함된 제목 게시글 갯수 세기
    public int searchInPostsCount(String searchKeyWord);*/

    //meet 게시글에서 searchKeyWord가 포함된 제목 게시글 갯수 세기
    public int searchInPostsCountInMeet(String searchKeyWord);

    //lodging 게시글에서 searchKeyWord가 포함된 제목 게시글 갯수 세기
    public int searchInPostsCountInLodging(String searchKeyWord);


}


