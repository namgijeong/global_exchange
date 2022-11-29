package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DiaryDTO {
    private Long diaryNumber;
    private Long memberNumber;
    private Long diaryPartnerNumber;
    private Long diaryTitle;
    private Long diaryContent;
    private Long diaryWriteDate;
    private Long diaryUpdateDate;

    private FileDiaryVO fileDiaryVO;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
