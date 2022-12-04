package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.FileDiaryVO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/fileDiary/*")
public class FileDiaryController {
    @PostMapping("/upload")
    public FileDiaryVO upload(MultipartFile upload) throws IOException{
        String rootPath = "C:/globalExchangeImages";
        String uploadPath = getUploadPath();
        FileDiaryVO fileDiaryVO = new FileDiaryVO();

        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        UUID uuid = UUID.randomUUID();
        String fileName = upload.getOriginalFilename();
        String uploadFileName = uuid.toString() + "_" + fileName;

        fileDiaryVO.setFileName(fileName);
        fileDiaryVO.setFileUuid(uuid.toString());
        fileDiaryVO.setFileUploadPath(getUploadPath());
        fileDiaryVO.setFileSize(upload.getSize());

//        log.info("upload: "+upload);

        File fullPath = new File(uploadFullPath, uploadFileName);
        upload.transferTo(fullPath);

        if(Files.probeContentType(fullPath.toPath()).startsWith("image")){
            FileOutputStream out = new FileOutputStream(new File(uploadFullPath, "s_" + uploadFileName));
            Thumbnailator.createThumbnail(upload.getInputStream(), out, 375, 375);
            out.close();
            fileDiaryVO.setFileImageCheck(true);
        }

        return fileDiaryVO;
    }
    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/globalExchangeImages", fileName));
    }


    
    @PostMapping("/delete")
    public void delete(FileDiaryVO fileDiaryVO) {
        File file = new File("C:/globalExchangeImages", fileDiaryVO.getFileUploadPath() + "/" + fileDiaryVO.getFileName());
        if(file.exists()){
            file.delete();
        }
        if(fileDiaryVO.isFileImageCheck()){
            file = new File("C:/globalExchangeImages", fileDiaryVO.getFileUploadPath() + "/s_" + fileDiaryVO.getFileName());
            if(file.exists()){
                file.delete();
            }
        }
    }
    
}
