package com.globalexchange.app.repository;
//

import com.globalexchange.app.domain.vo.*;

import com.globalexchange.app.mapper.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//
//
@Repository
@RequiredArgsConstructor
public class SearchDAO {
    private final SearchMapper searchMapper;

    //meet 게시글에서 searchKeyWord가 포함된 제목 게시글 리스트 뽑기
    public List<MeetVO> searchInMeetPosts(@Param("criteria") Criteria criteria, @Param("searchKeyWord") String searchKeyWord){
        return searchMapper.searchInMeetPosts(criteria, searchKeyWord);
    }


    //meet 게시글에서 searchKeyWord가 포함된 제목 게시글 갯수 세기
    public int searchInMeetPostsCount(String searchKeyWord){
        return searchMapper.searchInMeetPostsCount(searchKeyWord);
    }

    //lodging 게시글에서 searchKeyWord가 포함된 제목 게시글 리스트 뽑기
    public List<LodgingVO> searchInLodgingPosts(@Param("criteria") Criteria criteria, @Param("searchKeyWord") String searchKeyWord){
        return searchMapper.searchInLodgingPosts(criteria,searchKeyWord);
    }

    //lodging 게시글에서 searchKeyWord가 포함된 제목 게시글 갯수 세기
    public int searchInLodgingPostsCount(String searchKeyWord){
        return searchMapper.searchInLodgingPostsCount(searchKeyWord);
    }

}
