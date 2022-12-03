package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MeetAnswerCommentDTO {
    private Long meetAnswerCommentNumber;
    private Long memberNumber;
    private String meetAnswerCommentContent;
    private String meetCommentWriteDate;
    private String meetCommentUpdateDate;
    private Long meetAnswerNumber;

    private String memberNickname;

    private Long fileNumber;
    private String fileName;
    private String fileUploadPath;
    private String fileUuid;
    private boolean fileImageCheck;
    private Long fileSize;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
