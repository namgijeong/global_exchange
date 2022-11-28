package com.globalexchange.app.mapper;

import com.globalexchange.app.domain.vo.FileProfileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    public FileProfileVO getMeetWriterImage(Long memberNumber);
}
