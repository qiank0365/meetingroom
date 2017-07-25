package com.meeting.room.controller;


import com.meeting.room.entity.MeetingEntity;
import com.meeting.room.entity.MeetingInfoEntity;
import com.meeting.room.service.IMeetingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MeetingController {

    @Resource
    private IMeetingService meetingService;

    @RequestMapping(value="/meeting", method=RequestMethod.GET)
    List<MeetingInfoEntity> listMeetingInfo() {
        return meetingService.ListMeetingInfo();
    }
}
