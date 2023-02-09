package com.globalexchange.app.service;

import com.globalexchange.app.domain.vo.*;
import com.globalexchange.app.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MeetDAO meetDAO;
    private final FileDAO fileDAO;
    private final LodgingDAO lodgingDAO;
    private final LodgingAnswerDAO lodgingAnswerDAO;
    /*private final FileLodgingDAO fileLodgingDAO;*/

    public List<MeetDTO> showAllLatestAnsweredMeet(){
        List<MeetVO> meetVOList = meetDAO.findAllLatestAnsweredMeet(new Criteria().create(1, 4));
        List<MeetDTO> meetDTOList = new ArrayList<>();

        for(MeetVO meetVO : meetVOList) {
            MeetDTO meetDTO = new MeetDTO();

            meetDTO.create(meetVO);
            meetDTO.setMeetAnswerCount(meetDAO.meetAnswerCount(meetVO.getMeetNumber()));
            meetDTO.setFileMeetVO(fileDAO.getMeetFile(meetVO.getMeetNumber()));

            meetDTOList.add(meetDTO);
        }

        return meetDTOList;
    }

    public List<MeetDTO> showAllLatestNotAnsweredMeet(){
        List<MeetVO> meetVOList = meetDAO.findAllLatestNotAnsweredMeet(new Criteria().create(1, 4));
        List<MeetDTO> meetDTOList = new ArrayList<>();

        for(MeetVO meetVO : meetVOList) {
            MeetDTO meetDTO = new MeetDTO();

            meetDTO.create(meetVO);
            meetDTO.setMeetAnswerCount(meetDAO.meetAnswerCount(meetVO.getMeetNumber()));
            meetDTO.setFileMeetVO(fileDAO.getMeetFile(meetVO.getMeetNumber()));

            meetDTOList.add(meetDTO);
        }

        return meetDTOList;
    }

    public List<LodgingDTO> showAllLatestAnsweredLodging(){
        List<LodgingVO> lodgingVOList = lodgingDAO.findAllLatestAnsweredLodging(new Criteria().create(1, 4));
        List<LodgingDTO> lodgingDTOList = new ArrayList<>();

        for(LodgingVO lodgingVO : lodgingVOList) {
            LodgingDTO lodgingDTO = new LodgingDTO();

            lodgingDTO.create(lodgingVO);
            lodgingDTO.setLodgingAnswerCount(lodgingAnswerDAO.findCount(lodgingVO.getLodgingNumber()));
            lodgingDTO.setFileLodgingVO(fileDAO.getLodgingFile(lodgingVO.getLodgingNumber()));

            lodgingDTOList.add(lodgingDTO);
        }

        return lodgingDTOList;
    }

    public List<LodgingDTO> showAllLatestNotAnsweredLodging(){
        List<LodgingVO> lodgingVOList = lodgingDAO.findAllLatestNotAnsweredLodging(new Criteria().create(1, 4));
        List<LodgingDTO> lodgingDTOList = new ArrayList<>();

        for(LodgingVO lodgingVO : lodgingVOList) {
            LodgingDTO lodgingDTO = new LodgingDTO();

            lodgingDTO.create(lodgingVO);
            lodgingDTO.setLodgingAnswerCount(lodgingAnswerDAO.findCount(lodgingVO.getLodgingNumber()));
            lodgingDTO.setFileLodgingVO(fileDAO.getLodgingFile(lodgingVO.getLodgingNumber()));

            lodgingDTOList.add(lodgingDTO);
        }

        return lodgingDTOList;
    }
}
