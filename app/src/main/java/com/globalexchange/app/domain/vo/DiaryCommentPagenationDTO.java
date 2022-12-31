package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class DiaryCommentPagenationDTO {
  private List<DiaryCommentDTO> diaryCommentDTOList;
  private long diaryCommentCount;
}
