package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MeetAnswerFileDTO {
    private Long meetNumber;
    private String meetTitle;
    private Long memberNumber;
    private String meetLearningLang;
    private String meetContent;
    private String meetWriteDate;
    private String meetUpdateDate;
    private String meetAddress;
    private String meetDetailAddress;

    private String memberTeachingLang;
    private String memberNickname;

    private FileMeetVO fileMeetVO;
    private FileProfileVO fileProfileVO;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
