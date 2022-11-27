package com.globalexchange.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EmailVO {
    private String emailTitle;
    private String emailPhone;
    private String clientEmail;
    private String emailContent;
}
