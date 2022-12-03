package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MeetDTO {
    private Long meetNumber;
    private String meetTitle;
    private Long memberNumber;
    private String meetLearningLang;
    private String meetContent;
    private String meetWriteDate;
    private String meetUpdateDate;
    private String meetAddress;
    private String meetDetailAddress;

    private String memberTeachingLang;
    private String memberNickname;

    private FileMeetVO fileMeetVO;
    private FileProfileVO fileProfileVO;

    private Long meetAnswerCount;

    public void create(MeetVO meetVO) {
        this.meetNumber = meetVO.getMeetNumber();
        this.meetTitle = meetVO.getMeetTitle();
        this.memberNumber = meetVO.getMemberNumber();
        this.meetLearningLang = meetVO.getMeetLearningLang();
        this.meetContent = meetVO.getMeetContent();
        this.meetWriteDate = meetVO.getMeetWriteDate();
        this.meetUpdateDate = meetVO.getMeetUpdateDate();
        this.meetAddress = meetVO.getMeetAddress();
        this.meetDetailAddress = meetVO.getMeetDetailAddress();
    }

}
