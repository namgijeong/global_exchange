package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberDTO {
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
    private FileProfileVO fileProfileVO;



//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }

    public void create(MemberVO memberVO) {
        this.memberNumber = memberVO.getMemberNumber();
        this.memberNickname = memberVO.getMemberNickname();
        this.memberPhoneNum = memberVO.getMemberPhoneNum();
        this.memberId = memberVO.getMemberId();
        this.memberBirthdate = memberVO.getMemberBirthdate();
        this.memberTeachingLang = memberVO.getMemberTeachingLang();
        this.memberLearningLang = memberVO.getMemberLearningLang();
        this.memberInteresting = memberVO.getMemberInteresting();
        this.memberIntroduce = memberVO.getMemberIntroduce();
    }


    public void create2(MemberVO memberVO) {
        this.memberNumber = memberVO.getMemberNumber();
        this.memberNickname = memberVO.getMemberNickname();
        this.memberPhoneNum = memberVO.getMemberPhoneNum();
        this.memberId = memberVO.getMemberId();
        this.memberBirthdate = memberVO.getMemberBirthdate();
        this.memberTeachingLang = memberVO.getMemberTeachingLang();
        this.memberLearningLang = memberVO.getMemberLearningLang();
        this.memberInteresting = memberVO.getMemberInteresting();
        this.memberIntroduce = memberVO.getMemberIntroduce();
        this.memberNationUrl = memberVO.getMemberNationUrl();
    }


    public void create(MemberVO memberVO,FileProfileVO fileProfileVO) {
        this.memberNumber = memberVO.getMemberNumber();
        this.memberId = memberVO.getMemberId();
        this.memberPassword = memberVO.getMemberPassword();
        this.memberTeachingLang = memberVO.getMemberTeachingLang();
        this.memberLearningLang = memberVO.getMemberLearningLang();
        this.memberInteresting = memberVO.getMemberInteresting();
        this.memberGender = memberVO.getMemberGender();
        this.memberNickname = memberVO.getMemberNickname();
        this.memberPhoneNum = memberVO.getMemberPhoneNum();
        this.memberBirthdate = memberVO.getMemberBirthdate();
        this.memberBirthdate = memberVO.getMemberBirthdate();
        this.memberIntroduce = memberVO.getMemberIntroduce();
        this.fileProfileVO = fileProfileVO;

    }

    public void create2(MemberVO memberVO,FileProfileVO fileProfileVO) {
        this.memberNumber = memberVO.getMemberNumber();
        this.memberId = memberVO.getMemberId();
        this.memberPassword = memberVO.getMemberPassword();
        this.memberTeachingLang = memberVO.getMemberTeachingLang();
        this.memberLearningLang = memberVO.getMemberLearningLang();
        this.memberInteresting = memberVO.getMemberInteresting();
        this.memberGender = memberVO.getMemberGender();
        this.memberNickname = memberVO.getMemberNickname();
        this.memberPhoneNum = memberVO.getMemberPhoneNum();
        this.memberBirthdate = memberVO.getMemberBirthdate();
        this.memberBirthdate = memberVO.getMemberBirthdate();
        this.memberIntroduce = memberVO.getMemberIntroduce();
        this.memberNationUrl = memberVO.getMemberNationUrl();
        this.fileProfileVO = fileProfileVO;

    }
}
