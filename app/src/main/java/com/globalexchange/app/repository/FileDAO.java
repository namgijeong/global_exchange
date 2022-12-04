package com.globalexchange.app.repository;


import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.FileDiaryVO;
import com.globalexchange.app.domain.vo.FileMeetVO;
import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    //    프로필이미지 조회
    public FileProfileVO getMeetWriterImage(Long memberNumber){
        return fileMapper.getMeetWriterImage(memberNumber);
    }
    // meet게시글 이미지 등록
    public void insertMeetFile(FileMeetVO fileMeetVO){
        fileMapper.insertMeetFile(fileMeetVO);
    }

    //meet 게시글 파일 불러오기
    public FileMeetVO getMeetFile(Long meet_number){
        return fileMapper.getMeetFile(meet_number);
    }
    //meet 게시글 수정할때 meet게시글에 원래 있던 파일 지우기
    public void deleteMeetFile(Long meet_number){
        fileMapper.deleteMeetFile(meet_number);
    }

    //    일기 파일 추가
    public void diarySave(FileDiaryVO fileDiaryVO){
        fileMapper.diaryInsert(fileDiaryVO);
    }
    //    일기 파일 수정
//    public void setFileDiaryVO(Long diaryNumber){
//        fileMapper.diaryUpdate(diaryNumber);
//    }
    //    일기 파일 삭제
    public void diaryRemove(Long diaryNumber){
        fileMapper.diaryDelete(diaryNumber);
    }
    //    일기 파일 조회
    public FileDiaryVO diaryFind(Long diaryNumber){
        return fileMapper.diarySelect(diaryNumber);
    }

}
