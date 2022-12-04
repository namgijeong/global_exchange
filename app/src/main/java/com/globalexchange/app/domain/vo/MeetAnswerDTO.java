package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MeetAnswerDTO {
    private Long meetAnswerNumber;
    private Long memberNumber;
    private String meetAnswerContent;
    private String meetAnswerWriteDate;
    private String meetAnswerUpdateDate;
    private Long meetNumber;

    private String memberNickname;

    private Long fileNumber;
    private String fileName;
    private String fileUploadPath;
    private String fileUuid;
    private boolean fileImageCheck;
    private Long fileSize;


    //json에서는 키 멤버변수, 값 변수값.. 객체안의 객체안의 요소 접근못함?
    //private FileProfileVO fileProfileVO;

//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
