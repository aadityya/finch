package com.finch.twitter.controller;

import com.finch.twitter.service.TimelineService;
import com.finch.common.vo.TimelineResponseVO;
import com.finch.common.vo.Tweet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/{userid}")
public class TimelineController {

    private static Logger LOGGER = LoggerFactory.getLogger(TimelineController.class);

    @Autowired
    TimelineService timelineService;

    @GetMapping(value = "/timeline")
    private TimelineResponseVO getTimeline(@PathVariable String userid) {

        LOGGER.debug("TimelineController");

        List<Tweet> tweets = timelineService.getTimeLineByUser(userid);

        TimelineResponseVO responseVO = new TimelineResponseVO();

        responseVO.setTweets(tweets);

        return responseVO;
    }
}
