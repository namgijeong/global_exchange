package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.repository.FileDAO;
import com.globalexchange.app.repository.MemberDAO;
import com.globalexchange.app.repository.SearchDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
@Slf4j
public class SearchObjectificationService implements SearchService{

    private final SearchDAO searchDAO;
    private final FileDAO fileDAO;

    // meet 게시글에서 searchKeyWord가 포함된 제목 게시글 리스트 뽑기
    @Override
    public List<PostDTO> searchKeyWordSelectAllInMeet(Criteria criteria, String searchKeyWord){
        List<MeetVO> meetVOList= searchDAO.searchInMeetPosts(criteria,searchKeyWord);
       /* List<LodgingVO> lodgingVOList= searchDAO.searchInLodgingPosts(criteria,searchKeyWord);*/
        log.info("검색한 결과: 만남과 도움 게시글"+meetVOList);
       /* log.info("검색한 결과: 숙소가 필요해 게시글"+lodgingVOList);*/
        List<PostDTO> postDTOList = new ArrayList<PostDTO>();

        meetVOList.forEach(meetVO->{
            PostDTO postDTO = new PostDTO();

            FileMeetVO fileMeetVO ;
            fileMeetVO=fileDAO.getMeetFile(meetVO.getMeetNumber());
            log.info("검색한 결과:만남과 도움 게시글 이미지"+ fileMeetVO);
            //null일때 postDTO.create하면 null객체에 set을 해서 오류가 된다
            if(fileMeetVO !=null){
                postDTO.create(fileMeetVO);
            }

            postDTO.create(meetVO);

            postDTOList.add(postDTO);
        });


        /*lodgingVOList.forEach(lodgingVO->{
            PostDTO postDTO = new PostDTO();

            FileLodgingVO fileLodgingVO;
            fileLodgingVO=fileDAO.getLodgingFile(lodgingVO.getLodgingNumber());
            log.info("검색한 결과:숙소가 필요해 게시글 이미지"+ fileLodgingVO);
            //null일때 postDTO.create하면 null객체에 set을 해서 오류가 된다
            if(fileLodgingVO !=null){
                postDTO.create(fileLodgingVO);
            }

            postDTO.create(lodgingVO);

            postDTOList.add(postDTO);
        });*/

        return postDTOList;
    }

    // lodging 게시글에서 searchKeyWord가 포함된 제목 게시글 리스트 뽑기
    @Override
    public List<PostDTO> searchKeyWordSelectAllInLodging(Criteria criteria, String searchKeyWord){
        /*List<MeetVO> meetVOList= searchDAO.searchInMeetPosts(criteria,searchKeyWord);*/
         List<LodgingVO> lodgingVOList= searchDAO.searchInLodgingPosts(criteria,searchKeyWord);
       /* log.info("검색한 결과: 만남과 도움 게시글"+meetVOList);*/
         log.info("검색한 결과: 숙소가 필요해 게시글"+lodgingVOList);
        List<PostDTO> postDTOList = new ArrayList<PostDTO>();

       /* meetVOList.forEach(meetVO->{
            PostDTO postDTO = new PostDTO();

            FileMeetVO fileMeetVO ;
            fileMeetVO=fileDAO.getMeetFile(meetVO.getMeetNumber());
            log.info("검색한 결과:만남과 도움 게시글 이미지"+ fileMeetVO);
            //null일때 postDTO.create하면 null객체에 set을 해서 오류가 된다
            if(fileMeetVO !=null){
                postDTO.create(fileMeetVO);
            }

            postDTO.create(meetVO);

            postDTOList.add(postDTO);
        });*/


        lodgingVOList.forEach(lodgingVO->{
            PostDTO postDTO = new PostDTO();

            FileLodgingVO fileLodgingVO;
            fileLodgingVO=fileDAO.getLodgingFile(lodgingVO.getLodgingNumber());
            log.info("검색한 결과:숙소가 필요해 게시글 이미지"+ fileLodgingVO);
            //null일때 postDTO.create하면 null객체에 set을 해서 오류가 된다
            if(fileLodgingVO !=null){
                postDTO.create(fileLodgingVO);
            }

            postDTO.create(lodgingVO);

            postDTOList.add(postDTO);
        });

        return postDTOList;
    }

    /* //meet +  lodging 게시글에서 searchKeyWord가 포함된 제목 게시글 갯수 세기
    public int searchInPostsCount(String searchKeyWord){
        int searchCount = searchDAO.searchInLodgingPostsCount(searchKeyWord)+ searchDAO.searchInMeetPostsCount(searchKeyWord);

        return searchCount;
    }*/

    //meet 게시글에서 searchKeyWord가 포함된 제목 게시글 갯수 세기
    @Override
    public int searchInPostsCountInMeet(String searchKeyWord){
        int searchCount = searchDAO.searchInMeetPostsCount(searchKeyWord);

        return searchCount;
    }

    //lodging 게시글에서 searchKeyWord가 포함된 제목 게시글 갯수 세기
    @Override
    public int searchInPostsCountInLodging(String searchKeyWord){
        int searchCount = searchDAO.searchInLodgingPostsCount(searchKeyWord);

        return searchCount;
    }


}
