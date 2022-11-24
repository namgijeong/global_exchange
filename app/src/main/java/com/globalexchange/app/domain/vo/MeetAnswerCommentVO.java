package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MeetAnswerCommentVO {
    private Long meetAnswerCommentNumber;
    private Long memberNumber;
    private String meetAnswerCommentContent;
    private String meetCommentWriteDate;
    private String meetCommentUpdateDate;
    private Long meetAnswerNumber;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
