package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class NoticeVO {
    private Long noticeNumber;
    private String noticeTitle;
    private String noticeContent;
    private String noticeWriteDate;
    private String noticeUpdateDate;

    public NoticeVO create(String noticeTitle, String noticeContent) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;

        return this;
    }
}
