package com.globalexchange.app.mapper;


import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.DiaryDTO;
import com.globalexchange.app.domain.vo.DiaryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DiaryMapperTest {
    @Autowired
    private DiaryMapper diaryMapper;

    @Test
    public void insertTest(){
        DiaryDTO diaryDTO = new DiaryDTO();
        diaryDTO.create(1L, 2L, "새로 작성한 게시글 제목", "새로 작성한 게시글 내용");
        diaryMapper.diaryInsert(diaryDTO);
        log.info("diaryNumber: " + diaryDTO.getDiaryNumber());
    }

    @Test
    public void updateTest(){
        DiaryDTO diaryDTO = new DiaryDTO();
        diaryDTO.create(diaryMapper.diarySelect(1L));
        diaryDTO.setDiaryTitle("수정된 게시글 제목");
        diaryMapper.diaryUpdate(diaryDTO);
    }

    @Test
    public void selectTest(){
        log.info("diary: " + diaryMapper.diarySelect(1L));
    }

    @Test
    public void selectAllTest(){
        diaryMapper.diarySelectAll(new Criteria().create(1, 10)).stream().map(DiaryVO::getDiaryTitle).forEach(log::info);
    }
}


















