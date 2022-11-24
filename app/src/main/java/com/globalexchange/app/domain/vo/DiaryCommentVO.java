package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DiaryCommentVO {
    private Long diaryCommentNumber;
    private Long memberNumber;
    private Long diaryCommentContent;
    private Long diaryCommentWriteDate;
    private Long diaryCommentUpdateDate;
    private Long diaryNumber;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
