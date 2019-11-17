package com.finch.processor.service;

import com.finch.common.vo.TimelineResponseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="fin-twitter", fallback = TwitterClientImpl.class)
public interface TwitterClient {

    @RequestMapping(value = "/user/{userid}/timeline", method = RequestMethod.GET)
    TimelineResponseVO getTimeline(@PathVariable String userid);
}
