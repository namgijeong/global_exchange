package com.globalexchange.app.domain.vo;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
@Getter
public class Criteria {
    private int page;
    private int amount;
    private String memberTeachingLang;

    public Criteria create(int page, int amount) {
        this.page = page;
        this.amount = amount;
        return this;
    }

    public Criteria create(int page, int amount, String memberTeachingLang) {
        this.page = page;
        this.amount = amount;
        this.memberTeachingLang = memberTeachingLang;
        return this;
    }

    public String getQueryString(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("page", this.page)
                .queryParam("amount", this.amount);
        return builder.toUriString();
    }
}
