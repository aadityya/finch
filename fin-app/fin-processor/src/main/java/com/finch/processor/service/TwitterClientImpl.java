package com.finch.processor.service;

import com.finch.common.vo.TimelineResponseVO;
import com.finch.common.vo.Tweet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TwitterClientImpl implements TwitterClient {
    @Override
    public TimelineResponseVO getTimeline(String userid) {
        TimelineResponseVO responseVO = new TimelineResponseVO();
        List<Tweet> tweets = new ArrayList();
        Tweet tweet = new Tweet();
        tweet.setMessage("Dummy Tweet");
        tweets.add(tweet);
        responseVO.setTweets(tweets);
        return responseVO;
    }
}
