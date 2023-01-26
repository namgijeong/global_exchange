package com.globalexchange.app.domain.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
public class PostDTO {
    private Long postNumber;
    private String postTitle;
    private String postLearningLang;

    private FileVO fileVO;

    private String postType;

    private String searchKeyWord;

    public void create(MeetVO meetVO) {
        this.postNumber = meetVO.getMeetNumber();
        this.postTitle = meetVO.getMeetTitle();
        this.postLearningLang = meetVO.getMeetLearningLang();
        this.postType="MEET";

    }

    public void create(LodgingVO lodgingVO) {
        this.postNumber = lodgingVO.getLodgingNumber();
        this.postTitle = lodgingVO.getLodgingTitle();
        this.postLearningLang = lodgingVO.getLodgingLearningLang();
        this.postType="LODGING";
    }

    public void create(FileMeetVO fileMeetVO) {
        log.info("meet게시글에서 가져온 filevo create하기 전"+fileMeetVO);
        log.info("meet게시글에서 가져온 filevo create하기 전"+fileMeetVO.getFileNumber());
        log.info("meet게시글에서 가져온 filevo create하기 전"+fileMeetVO.getFileName());
        log.info("meet게시글에서 가져온 filevo create하기 전"+fileMeetVO.getFileSize());
        //new로 객체를 생성 안하면 set을 못하지!!!
        fileVO= new FileVO();
        fileVO.setFileNumber(fileMeetVO.getFileNumber());
        fileVO.setFileName(fileMeetVO.getFileName());
        fileVO.setFileSize(fileMeetVO.getFileSize());
        //boolean 타입을 get할때는 is
        fileVO.setFileImageCheck(fileMeetVO.isFileImageCheck());
        fileVO.setFileUploadPath(fileMeetVO.getFileUploadPath());
        fileVO.setFileUuid(fileMeetVO.getFileUuid());
        fileVO.setBoardNumber(fileMeetVO.getMeetNumber());
        log.info("meet게시글에서 가져온 filevo create하기 후"+fileVO);
    }

    public void create(FileLodgingVO fileLodgingVO) {
        log.info("lodging 게시글에서 가져온 filevo create하기 전"+fileLodgingVO);
        log.info("lodging 게시글에서 가져온 filevo create하기 전"+fileLodgingVO.getFileNumber());
        log.info("lodging 게시글에서 가져온 filevo create하기 전"+fileLodgingVO.getFileName());
        log.info("lodging 게시글에서 가져온 filevo create하기 전"+fileLodgingVO.getFileSize());
        //new로 객체를 생성 안하면 set을 못하지!!!
        fileVO= new FileVO();
        fileVO.setFileNumber(fileLodgingVO.getFileNumber());
        fileVO.setFileName(fileLodgingVO.getFileName());
        fileVO.setFileSize(fileLodgingVO.getFileSize());
        fileVO.setFileImageCheck(fileLodgingVO.isFileImageCheck());
        fileVO.setFileUploadPath(fileLodgingVO.getFileUploadPath());
        fileVO.setFileUuid(fileLodgingVO.getFileUuid());
        fileVO.setBoardNumber(fileLodgingVO.getLodgingNumber());
        log.info("lodging 게시글에서 가져온 filevo create하기 후"+fileVO);
    }
}
