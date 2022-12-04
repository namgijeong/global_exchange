package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.FileMeetVO;
import com.globalexchange.app.domain.vo.FileProfileVO;
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

@RestController
@RequestMapping("/fileProfile/*")
public class FileProfileController {
    @PostMapping("/upload")
    public FileProfileVO upload(MultipartFile upload) throws IOException{
        String rootPath = "C:/globalExchangeImages";
        String uploadPath = getUploadPath();
        FileProfileVO fileProfileVO = new FileProfileVO();

        File uploadFullPath = new File(rootPath, uploadPath);
        if(!uploadFullPath.exists()){uploadFullPath.mkdirs();}

        UUID uuid = UUID.randomUUID();
        String fileName = upload.getOriginalFilename();
        String uploadFileName = uuid.toString() + "_" + fileName;

        fileProfileVO.setFileName(fileName);
        fileProfileVO.setFileUuid(uuid.toString());
        fileProfileVO.setFileUploadPath(getUploadPath());
        fileProfileVO.setFileSize(upload.getSize());

        File fullPath = new File(uploadFullPath, uploadFileName);
        upload.transferTo(fullPath);

        if(Files.probeContentType(fullPath.toPath()).startsWith("image")){
            FileOutputStream out = new FileOutputStream(new File(uploadFullPath, "s_" + uploadFileName));
            Thumbnailator.createThumbnail(upload.getInputStream(), out, 100, 100);
            out.close();
            fileProfileVO.setFileImageCheck(true);

        }

        return fileProfileVO;
    }


    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException{
        /*File file=new File("C:/globalExchangeImages", fileName);
        if(file.isFile()){
            return FileCopyUtils.copyToByteArray(file);
        }
        file=new File("images/noImage/no-image.jpg");
        return FileCopyUtils.copyToByteArray(file);*/
       return FileCopyUtils.copyToByteArray(new File("C:/globalExchangeImages", fileName));

    }

}
