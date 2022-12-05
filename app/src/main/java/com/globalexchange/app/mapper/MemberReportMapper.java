package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberReportMapper {
   // 멤버 신고
   public void insertReport(Long reportingMemberNumber, Long reportedMemberNumber);

   // 멤버 신고 횟수 조회
   public int getReportsCount(Long reportedMemberNumber);
}
