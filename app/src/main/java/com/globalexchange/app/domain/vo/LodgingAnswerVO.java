package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LodgingAnswerVO {
    private Long lodgingAnswerNumber;
    private Long memberNumber;
    private String lodgingAnswerContent;
    private String lodgingAnswerWriteDate;
    private String lodgingAnswerUpdateDate;
    private Long lodgingNumber;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
