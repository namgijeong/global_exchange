package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
   int checkId(String memberId);
   int checkNick(String memberNick);
   Long emailLogin(MemberVO memberVO);
   void joinForm(MemberVO memberVO);



}
