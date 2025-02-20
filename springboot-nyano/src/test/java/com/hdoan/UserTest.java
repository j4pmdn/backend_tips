package com.hdoan;/*
 * @project springboot-nyano
 * @author Huy
 */

import com.hdoan.entity.feed.FeedEntity;
import com.hdoan.entity.user.UserEntity;
import com.hdoan.repository.FeedRepository;
import com.hdoan.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Collections;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(false)
    void
    oneToManyTest() {
        try {
            // 1. New User
            UserEntity user = new UserEntity();
            FeedEntity feed = new FeedEntity();

            user.setUserName("Tips Java");
            user.setUserEmail("tipsjava@gmail.com");

            feed.setFeedTitle("feed 01");
            feed.setDescription("This is a description"); // Set the description

            user.setFeeds(Collections.singletonList(feed));
            feed.setUser(user);
            userRepository.save(user);
            feedRepository.save(feed);
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to see the root cause
        }
    }

    @Test
    @Transactional
    @Rollback(false)
    void
    oneToManyTestTwo() {
        try {
            // 1. New User
            UserEntity user = new UserEntity();
            FeedEntity feed = new FeedEntity();

            user.setUserName("Tips Go");
            user.setUserEmail("tipsgo@gmail.com");

            feed.setFeedTitle("feed 02");
            feed.setDescription("This is a description"); // Set the description

            user.setFeeds(Collections.singletonList(feed));
            feed.setUser(user);
            userRepository.save(user);
            //feedRepository.save(feed);
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Re-throw the exception to see the root cause
        }
    }

    @Test
    @Transactional
    void selectOneToManyTest(){
        UserEntity user = userRepository.findById(18L).orElseThrow();
        System.out.println(user);
        System.out.println(user.getFeeds());
    }
}