package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.DiaryDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DiaryMapperTest {

  @Autowired
  private DiaryMapper diaryMapper;

  @Test
  void diaryUpdate() {
    DiaryDTO diaryDTO = new DiaryDTO();
    diaryDTO.setDiaryNumber(1L);
    diaryDTO.setDiaryTitle("업데이트테스트");
    diaryDTO.setDiaryContent("업데이트테스트");
    diaryMapper.diaryUpdate(diaryDTO);

  }
}