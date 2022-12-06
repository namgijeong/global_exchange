package com.globalexchange.app.repository;//package com.globalexchange.app.repository;


import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.mapper.MemberMapper;
import com.globalexchange.app.mapper.MemberReportMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberReportDAO {

    private final MemberReportMapper memberReportMapper;

    // 멤버 신고
    public void saveReport(Long reportingMemberNumber, Long reportedMemberNumber){
        memberReportMapper.insertReport(reportingMemberNumber, reportedMemberNumber);
    }

    // 멤버 신고 횟수 조회
    public int findReportsCount(Long reportedMemberNumber){
        return memberReportMapper.getReportsCount(reportedMemberNumber);
    }

}