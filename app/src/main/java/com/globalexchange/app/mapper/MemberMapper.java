package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
   int checkId(String checkId);
   int join(MemberVO memberVO);
   MemberVO login(MemberVO memberVO);

//   public void MemberJoin(MemberVO memberVO);

}
