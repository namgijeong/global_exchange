package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.DiaryDTO;
import com.globalexchange.app.domain.vo.DiaryVO;
import com.globalexchange.app.repository.DiaryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryObjectificationService implements DiaryService {

  private final DiaryDAO diaryDAO;

  @Override
  public void register(DiaryDTO diaryDTO) {
    diaryDAO.save(diaryDTO);

  }

  @Override
  public void modify(DiaryDTO diaryDTO) {
    diaryDAO.setDiaryVO(diaryDTO);
  }

  @Override
  public void remove(Long diaryNumber) {
    diaryDAO.remove(diaryNumber);
  }

  @Override
  public DiaryDTO show(Long diaryNumber) {
    DiaryDTO diaryDTO = new DiaryDTO();
    diaryDTO.create(diaryDAO.findById(diaryNumber));
    return diaryDTO;
  }

  @Override
  public List<DiaryVO> showAll(Criteria criteria) {
    return diaryDAO.findAll(criteria);
  }

  @Override
  public int getTotal() {
    return diaryDAO.findCountAll();
  }
}
