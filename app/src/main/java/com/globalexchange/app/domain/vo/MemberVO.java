package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberVO {

    private Long memberNumber;
    private String memberId;
    private String memberPassword;
    private String memberTeachingLang;
    private String memberLearningLang;
    private String memberInteresting;
    private String memberGender;
    private String memberNickname;
    private String memberPhoneNum;
    private String memberBirthdate;
    private String memberIntroduce;
    private String memberNationUrl;
}
