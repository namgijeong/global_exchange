package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LodgingVO {
    private Long lodgingNumber;
    private String lodgingTitle;
    private Long memberNumber;
    private String lodgingLearningLang;
    private String lodgingContent;
    private String lodgingWriteDate;
    private String lodgingUpdateDate;
    private String lodgingAddress;
    private String lodgingDetailAddress;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
