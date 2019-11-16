package com.finch.processor.controller;

import com.finch.common.vo.TimelineResponseVO;
import com.finch.processor.service.TwitterClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/{userid}")
public class TwitterContoller {

    private static Logger LOGGER = LoggerFactory.getLogger(TwitterContoller.class);

    @Autowired
    TwitterClient twitterClient;

    @GetMapping(value = "/timeline")
    private TimelineResponseVO getTimeline(@PathVariable String userid) {

        LOGGER.debug("Twitter Controller");

        TimelineResponseVO timelineResponseVO = twitterClient.getTimeline(userid);

        return timelineResponseVO;
    }
}
