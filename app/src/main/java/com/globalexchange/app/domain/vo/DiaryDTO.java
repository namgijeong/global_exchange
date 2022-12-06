package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class DiaryDTO {
    private Long diaryNumber;
    private Long memberNumber;
    private Long diaryPartnerNumber;
    private String diaryTitle;
    private String diaryContent;
    private String diaryWriteDate;
    private String diaryUpdateDate;

    private String memberTeachingLang;
    private String memberNickname;
    private String diaryPartnerNickname;
    private String memberNationUrl;

    private FileDiaryVO fileDiaryVO;
    private FileProfileVO fileProfileVO;
    private FileProfileVO filePartnerProfileVO;

    public void create(Long memberNumber, Long diaryPartnerNumber, String diaryTitle, String diaryContent){
        this.memberNumber = memberNumber;
        this.diaryPartnerNumber = diaryPartnerNumber;
        this.diaryTitle = diaryTitle;
        this.diaryContent =diaryContent;
    }

    public void create(DiaryVO diaryVO){
        this.diaryNumber = diaryVO.getDiaryNumber();
        this.memberNumber = diaryVO.getMemberNumber();
        this.diaryPartnerNumber = diaryVO.getDiaryPartnerNumber();
        this.diaryTitle = diaryVO.getDiaryTitle();
        this.diaryContent = diaryVO.getDiaryContent();
        this.diaryWriteDate = diaryVO.getDiaryWriteDate();
        this.diaryUpdateDate = diaryVO.getDiaryUpdateDate();
    }


    public void create(String diaryTitle, String diaryContent, FileDiaryVO fileDiaryVO) {
        this.diaryTitle = diaryTitle;
        this.diaryContent = diaryContent;
        this.fileDiaryVO = fileDiaryVO;
    }

    public void create(Long diaryNumber, FileDiaryVO fileDiaryVO) {
        this.diaryNumber = diaryNumber;
        this.fileDiaryVO = fileDiaryVO;
    }

}
