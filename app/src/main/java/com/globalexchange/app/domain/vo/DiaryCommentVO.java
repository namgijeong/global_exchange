package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DiaryCommentVO {
    private Long diaryCommentNumber;
    private Long memberNumber;
    private String diaryCommentContent;
    private String diaryCommentWriteDate;
    private String diaryCommentUpdateDate;
    private Long diaryNumber;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
