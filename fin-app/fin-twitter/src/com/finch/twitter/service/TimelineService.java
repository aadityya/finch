package com.finch.twitter.service;

import com.finch.twitter.config.TwitterConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import com.finch.common.vo.Tweet;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimelineService {

    @Autowired
    TwitterConfiguration config;

    public List<Tweet> getTimeLineByUser(String userName) {

        List<Tweet> tweets = new ArrayList<>();
        Twitter twitter = config.getTwitterHandle();

        try {
            twitter.getUserTimeline(userName).stream().forEach(status -> {
                Tweet tweet = new Tweet();
                tweet.setMessage(status.getText());
                tweets.add(tweet);
            });
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return tweets;
    }


}
