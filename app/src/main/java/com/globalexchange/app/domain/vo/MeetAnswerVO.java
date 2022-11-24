package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MeetAnswerVO {
    private Long meetAnswerNumber;
    private Long memberNumber;
    private String meetAnswerContent;
    private String meetAnswerWriteDate;
    private String meetAnswerUpdateDate;
    private String meetNumber;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
