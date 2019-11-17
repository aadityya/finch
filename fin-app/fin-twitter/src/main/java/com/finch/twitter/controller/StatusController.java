package com.finch.twitter.controller;

import com.finch.twitter.service.StatusService;
import com.finch.common.vo.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tweet")
public class StatusController {

    @Autowired
    StatusService service;

    @PostMapping("write")
    public void postStatus(@RequestBody Tweet tweet) {
        Tweet responseTweet = service.postTweet(tweet);
    }

    @PutMapping("update")
    public void updateStatus(@RequestBody Tweet tweet) {
        Tweet responseTweet = service.updateTweet(tweet);
    }

    @DeleteMapping("delete")
    public void deleteStatus(@RequestBody Tweet tweet) {
        Tweet responseTweet = service.deleteTweet(tweet);
    }
}
