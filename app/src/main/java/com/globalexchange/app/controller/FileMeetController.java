package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.FileMeetVO;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fileMeet/*")
public class FileMeetController {
    @PostMapping("/upload")
    public FileMeetVO upload(MultipartFile upload) throws IOException{
        String rootPath = "C:/globalExchangeImages";
        String uploadPath = getUploadPath();
        FileMeetVO fileMeetVO = new FileMeetVO();

        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        UUID uuid = UUID.randomUUID();
        String fileName = upload.getOriginalFilename();
        String uploadFileName = uuid.toString() + "_" + fileName;

        fileMeetVO.setFileName(fileName);
        fileMeetVO.setFileUuid(uuid.toString());
        fileMeetVO.setFileUploadPath(getUploadPath());
        fileMeetVO.setFileSize(upload.getSize());

        File fullPath = new File(uploadFullPath, uploadFileName);
        upload.transferTo(fullPath);

        if(Files.probeContentType(fullPath.toPath()).startsWith("image")){

            fileMeetVO.setFileImageCheck(true);
        }

        return fileMeetVO;
    }
    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }
}
