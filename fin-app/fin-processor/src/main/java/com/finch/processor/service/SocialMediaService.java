package com.finch.processor.service;

import com.finch.common.vo.TimelineResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SocialMediaService {

    @Autowired
    TwitterClient twitterClient;

    public TimelineResponseVO getTimeline(String userid) {
        return twitterClient.getTimeline(userid);
    }

}
