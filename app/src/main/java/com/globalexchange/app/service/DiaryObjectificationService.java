package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.DiaryDTO;
import com.globalexchange.app.domain.vo.DiaryVO;
import com.globalexchange.app.domain.vo.FileDiaryVO;
import com.globalexchange.app.repository.DiaryDAO;
import com.globalexchange.app.repository.FileDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor @Qualifier("diary") @Primary
public class DiaryObjectificationService implements DiaryService {

  private final DiaryDAO diaryDAO;
  private final FileDAO fileDAO;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void register(DiaryDTO diaryDTO) {
    diaryDAO.save(diaryDTO);
    FileDiaryVO fileDiaryVO = diaryDTO.getFileDiaryVO();
    Optional.ofNullable(fileDiaryVO).ifPresent(file -> {
      file.setDiaryNumber(diaryDTO.getDiaryNumber());
      fileDAO.diarySave(file);
    });
  }

  @Override
  public void modify(DiaryDTO diaryDTO) {
    diaryDAO.setDiaryVO(diaryDTO);
    FileDiaryVO file = diaryDTO.getFileDiaryVO();
    Optional.ofNullable(file).ifPresent(file1 -> {
      file1.setDiaryNumber(diaryDTO.getDiaryNumber());
      fileDAO.diarySave(file1);
    });
  }

  @Override
  public void remove(Long diaryNumber) {
    fileDAO.diaryRemove(diaryNumber);
    diaryDAO.remove(diaryNumber);
  }

  @Override
  public DiaryDTO show(Long diaryNumber) {
    DiaryDTO diaryDTO = new DiaryDTO();
    diaryDTO.create(diaryDAO.findById(diaryNumber));
    diaryDTO.setFileDiaryVO(fileDAO.diaryFind(diaryNumber));
    return diaryDTO;
  }


  @Override
  public List<DiaryDTO> showAll(Criteria criteria) {
    List<DiaryDTO> list = diaryDAO.findAll(criteria);
    List<DiaryDTO> list2 = new ArrayList<>();

    log.info("list: "+list);
//    DiaryVO diaryVO = new DiaryVO();
    for(DiaryDTO diaryDTO : list) {
      {
        diaryDTO.create(diaryDAO.findById(diaryDTO.getDiaryNumber()));
        log.info("diaryNumber;"+diaryDTO.getDiaryNumber());
//        DiaryDTO diaryDTO = new DiaryDTO();
//        diaryDTO.create(diaryDAO.findById(diaryNumber));
        diaryDTO.setFileDiaryVO(fileDAO.diaryFind(diaryDTO.getDiaryNumber()));
        log.info("diaryDTO:"+diaryDTO);
        list2.add(diaryDTO);

      }
    }
    log.info("list2: " + list2);
    return list2;
//    }}

//    }


//    diaryDTO.create(diaryDAO.findAll(criteria), fileDAO.diaryFind(criteria));
//    diaryDTO.setFileDiaryVO(fileDAO.diaryFind(criteria));

//    return diaryDTO;

//    return diaryDAO.findAll(criteria);
  }

  @Override
  public int getTotal() {
    return diaryDAO.findCountAll();
  }
}
