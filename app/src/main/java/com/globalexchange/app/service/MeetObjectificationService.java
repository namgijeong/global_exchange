package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.domain.vo.MeetVO;
import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.repository.FileDAO;
import com.globalexchange.app.repository.MeetDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetObjectificationService implements MeetService{
    private final MeetDAO meetDAO;
    private final FileDAO fileDAO;
    @Override
    public List<MeetVO> meetSelectAll(Criteria criteria){

       return  meetDAO.meetSelectAll(criteria);
    }
    @Override
    public List<MeetVO> categoryMeetSelectAll(Criteria criteria,String meetLearningLang){
        return meetDAO.categoryMeetSelectAll(criteria,meetLearningLang);
    }
    @Override
    public int getTotal(){
        return meetDAO.getTotal();
    }
    @Override
    public int categoryGetTotal(String meetLearningLang) {
        return meetDAO.categoryGetTotal(meetLearningLang);
    }

    //작성자 정보 가져오기
    @Override
    public MemberVO writerInfo(Long memberNumber){
        return meetDAO.writerInfo(memberNumber);
    }

    //작성자 프로필이미지 가져오기
    public FileProfileVO getMeetWriterImage(Long memberNumber){
        return fileDAO.getMeetWriterImage(memberNumber);
    }
}
