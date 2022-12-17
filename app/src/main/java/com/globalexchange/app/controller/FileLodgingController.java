package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.FileLodgingVO;
import com.globalexchange.app.domain.vo.FileMeetVO;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/fileLodging/*")
public class FileLodgingController {
    @PostMapping("/upload")
    public FileLodgingVO upload(MultipartFile upload) throws IOException{
        String rootPath = "C:/globalExchangeImages";
        String uploadPath = getUploadPath();
        FileLodgingVO fileLodgingVO = new FileLodgingVO();

        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        UUID uuid = UUID.randomUUID();
        String fileName = upload.getOriginalFilename();
        String uploadFileName = uuid.toString() + "_" + fileName;

        fileLodgingVO.setFileName(fileName);
        fileLodgingVO.setFileUuid(uuid.toString());
        fileLodgingVO.setFileUploadPath(getUploadPath());
        fileLodgingVO.setFileSize(upload.getSize());

        File fullPath = new File(uploadFullPath, uploadFileName);
        upload.transferTo(fullPath);

        if(Files.probeContentType(fullPath.toPath()).startsWith("image")){

            fileLodgingVO.setFileImageCheck(true);
        }

        return fileLodgingVO;
    }
    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/globalExchangeImages", fileName));
    }
}
