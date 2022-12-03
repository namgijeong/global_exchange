package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DiaryVO {
    private Long diaryNumber;
    private Long memberNumber;
    private Long diaryPartnerNumber;
    private String diaryTitle;
    private String diaryContent;
    private String diaryWriteDate;
    private String diaryUpdateDate;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
