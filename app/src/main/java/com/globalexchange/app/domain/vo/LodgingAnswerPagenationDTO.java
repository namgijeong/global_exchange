package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class LodgingAnswerPagenationDTO {
    private List<LodgingAnswerDTO> lodgingAnswerDTOList;
    private long lodgingAnswerCount;


//    public void create(String fileName, String fileUploadPath, String fileUuid, boolean fileImageCheck) {
//        this.fileName = fileName;
//        this.fileUploadPath = fileUploadPath;
//        this.fileUuid = fileUuid;
//        this.fileImageCheck = fileImageCheck;
//    }
}
