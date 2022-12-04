package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.FileDiaryVO;
import com.globalexchange.app.domain.vo.FileMeetVO;
import com.globalexchange.app.domain.vo.FileProfileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    public FileProfileVO getMeetWriterImage(Long memberNumber);
    //meet게시글 파일 디비에 등록
    public void insertMeetFile(FileMeetVO fileMeetVO);

    //meet 게시글 파일 불러오기
    public FileMeetVO getMeetFile(Long meet_number);

    //meet 게시글 수정할때 meet게시글에 원래 있던 파일 지우기
    public void deleteMeetFile(Long meet_number);

    //    일기 파일 추가
    public void diaryInsert(FileDiaryVO fileDiaryVO);
    //    일기 파일 수정
//    public void diaryUpdate(Long diaryNumber);

    //    일기 파일 삭제
    public void diaryDelete(Long diaryNumber);
    //    일기 파일 조회
    public FileDiaryVO diarySelect(Long diaryNumber);

}
