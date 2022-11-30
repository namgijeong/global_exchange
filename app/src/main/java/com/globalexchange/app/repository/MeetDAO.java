package com.globalexchange.app.repository;
//

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.MeetDTO;
import com.globalexchange.app.domain.vo.MeetVO;
import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.mapper.MeetMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
//
import java.util.List;
//
@Repository
@RequiredArgsConstructor
public class MeetDAO{
    private final MeetMapper meetMapper;

    public List<MeetVO> meetSelectAll(Criteria criteria){
        return meetMapper.meetSelectAll(criteria);
    }
    public List<MeetVO> categoryMeetSelectAll(Criteria criteria,String meetLearningLang){
        return meetMapper.categoryMeetSelectAll(criteria, meetLearningLang);
    }
    public int getTotal(){
        return meetMapper.getTotal();
    }

    public int categoryGetTotal(String meetLearningLang) {
        return meetMapper.categoryGetTotal(meetLearningLang);
    }

    //작성자 정보 가져오기
    public MemberVO writerInfo(Long memberNumber){
        return meetMapper.writerInfo(memberNumber);
    }

    //meet 게시글 등록
    public void insertRequest(MeetDTO meetDTO){
        meetMapper.insertRequest(meetDTO);
    }

    //meet 게시글 detail 이동
    public MeetVO selectMeetRequest(Long meetNumber){
        return meetMapper.selectMeetRequest(meetNumber);
    }

    //meet 게시글 update
    public void updateRequest(MeetDTO meetDTO){
        meetMapper.updateRequest(meetDTO);
    }
    //meet 게시글 delete
    public void deleteRequest(Long meetNumber){
        meetMapper.deleteRequest(meetNumber);
    }
}
