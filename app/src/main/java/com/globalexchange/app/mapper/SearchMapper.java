package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {
    //meet 게시글에서 searchKeyWord가 포함된 제목 게시글 리스트 뽑기
    public List<MeetVO> searchInMeetPosts(@Param("criteria") Criteria criteria, @Param("searchKeyWord") String searchKeyWord);

    //meet 게시글에서 searchKeyWord가 포함된 제목 게시글 갯수 세기
    public int searchInMeetPostsCount(String searchKeyWord);

    //lodging 게시글에서 searchKeyWord가 포함된 제목 게시글 리스트 뽑기
    public List<LodgingVO> searchInLodgingPosts(@Param("criteria") Criteria criteria, @Param("searchKeyWord") String searchKeyWord);

    //lodging 게시글에서 searchKeyWord가 포함된 제목 게시글 갯수 세기
    public int searchInLodgingPostsCount(String searchKeyWord);
}
