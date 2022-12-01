package com.globalexchange.app.controller;

import com.globalexchange.app.domain.vo.Criteria;
import com.globalexchange.app.domain.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootTest
@Slf4j
public class AdminControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void noticeList() throws Exception {
        log.info("notices: " + mockMvc.perform(MockMvcRequestBuilders.get("/admin/noticeList")
                .param("page", "1")
                .param("amount", "10")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void noticeDetail() throws Exception{
        log.info("notice : " + mockMvc.perform(MockMvcRequestBuilders.get("/admin/noticeDetail")
                .param("noticeNumber", "258")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void noticeUpdate() throws Exception{
        log.info("noticeNumber : " + mockMvc.perform(MockMvcRequestBuilders.post("/admin/noticeUpdate")
                .param("noticeNumber", "250")
                .param("noticeTitle", "수정수정")
                .param("noticeContent", "수정수정")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void noticeDelete() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/noticeDelete")
                .param("noticeNumber", "250")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

    @Test
    void noticeWrite() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/noticeWrite")
                .param("noticeTitle", "추가")
                .param("noticeContent", "내용")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}