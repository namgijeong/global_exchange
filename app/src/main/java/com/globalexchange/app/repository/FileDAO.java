package com.globalexchange.app.repository;


import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;



@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;
//
//    //    파일 추가
//    public void save(FileVO fileVO){
//        fileMapper.insert(fileVO);
//    }
//    //    파일 삭제
//    public void remove(Long boardNumber){
//        fileMapper.delete(boardNumber);
//    }
    //    파일 조회
    public FileProfileVO getMeetWriterImage(Long memberNumber){
        return fileMapper.getMeetWriterImage(memberNumber);
    }
}
