package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.FileMeetVO;
import com.globalexchange.app.domain.vo.FileProfileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    public FileProfileVO getMeetWriterImage(Long memberNumber);
    //meet게시글 파일 디비에 등록
    public void insertMeetFile(FileMeetVO fileMeetVO);

    //meet 게시글 파일 불러오기
    public FileMeetVO getMeetFile(Long meet_number);

    //meet 게시글 수정할때 meet게시글에 원래 있던 파일 지우기
    public void deleteMeetFile(Long meet_number);
}
