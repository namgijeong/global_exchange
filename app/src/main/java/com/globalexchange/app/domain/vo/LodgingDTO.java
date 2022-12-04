package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LodgingDTO {
    private Long lodgingNumber;
    private String lodgingTitle;
    private Long memberNumber;
    private String lodgingLearningLang;
    private String lodgingContent;
    private String lodgingWriteDate;
    private String lodgingUpdateDate;
    private String lodgingAddress;
    private String lodgingDetailAddress;

    private String memberTeachingLang;
    private String memberNickname;

    private FileLodgingVO fileLodgingVO;
    private FileProfileVO fileProfileVO;

    private int lodgingAnswerCount;

    public void create(LodgingVO lodgingVO) {
        this.lodgingNumber =  lodgingVO.getLodgingNumber();
        this.lodgingTitle = lodgingVO.getLodgingTitle();
        this.memberNumber = lodgingVO.getMemberNumber();
        this.lodgingLearningLang = lodgingVO.getLodgingLearningLang();
        this.lodgingContent = lodgingVO.getLodgingContent();
        this.lodgingWriteDate = lodgingVO.getLodgingWriteDate();
        this.lodgingUpdateDate = lodgingVO.getLodgingUpdateDate();
        this.lodgingAddress = lodgingVO.getLodgingAddress();
        this.lodgingDetailAddress = lodgingVO.getLodgingDetailAddress();
    }
}
