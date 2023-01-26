package com.globalexchange.app.repository;

import com.globalexchange.app.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class SearchDAOTest {

    @Autowired
    private SearchDAO searchDAO;

    @Test
    void searchInMeetPosts() {
        log.info("searchList : " + searchDAO.searchInMeetPosts(new Criteria().create(1, 16), "여행"));
    }

/*    @Test
    void searchInMeetPostsCount() {
    }

    @Test
    void searchInLodgingPosts() {
    }

    @Test
    void searchInLodgingPostsCount() {
    }*/
}