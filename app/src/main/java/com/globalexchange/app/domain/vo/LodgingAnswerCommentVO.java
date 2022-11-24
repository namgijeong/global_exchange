package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LodgingAnswerCommentVO {
    private Long lodgingAnswerCommentNumber;
    private Long memberNumber;
    private String lodgingAnswerCommentContent;
    private String lodgingCommentWriteDate;
    private String lodgingCommentUpdateDate;
    private Long lodgingAnswerNumber;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
