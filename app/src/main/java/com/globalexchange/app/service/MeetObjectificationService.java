package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.MeetVO;
import com.globalexchange.app.repository.MeetDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetObjectificationService implements MeetService{
    private final MeetDAO meetDAO;
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
}
