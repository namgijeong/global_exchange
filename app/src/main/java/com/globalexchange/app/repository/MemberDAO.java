package com.globalexchange.app.repository;//package com.globalexchange.app.repository;


import com.globalexchange.app.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;


    public int checkId(String memberId,String memberPwd){ return memberMapper.checkId(memberId,memberPwd);}

}