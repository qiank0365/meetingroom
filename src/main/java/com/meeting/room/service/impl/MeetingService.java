package com.meeting.room.service.impl;

import com.meeting.room.entity.*;
import com.meeting.room.service.IMeetingService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class MeetingService implements IMeetingService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<MeetingInfoEntity> ListMeetingInfo() {
        List<MeetingInfoEntity> meetingInfoEntities = new ArrayList<MeetingInfoEntity>();

        /*meeting_room*/
        String sql = "SELECT * FROM MEETING_ROOM";
        List<MeetingRoomEntity> meetingRoomEntities = jdbcTemplate.query(
                sql, new BeanPropertyRowMapper<>(MeetingRoomEntity.class));
        for (MeetingRoomEntity MeetingRoomEntity : meetingRoomEntities) {
            MeetingInfoEntity meetingInfoEntity = new MeetingInfoEntity();
            meetingInfoEntity.setMeetingRoomName(MeetingRoomEntity.getName());
            /*meeting*/
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar c = Calendar.getInstance();
            String dateStart = sf.format(c.getTime());
            String dateEnd = dateStart.split(" ")[0] + " 23:59:59";
            //String dateStart = "2016-05-23 10:00:00";
            //String dateEnd = "2016-05-23 23:59:59";
            sql = "SELECT * FROM MEETING WHERE ROOM = ? AND to_char(END_DATE, 'yyyy-mm-dd hh24:mm:ss') >= ? AND to_char(END_DATE, 'yyyy-mm-dd hh24:mm:ss') < ?";
            List<MeetingEntity> meetingEntities = jdbcTemplate.query(sql,
                    new Object[]{MeetingRoomEntity.getId(), dateStart, dateEnd},
                    new BeanPropertyRowMapper<>(MeetingEntity.class));
            for (MeetingEntity meetingEntity : meetingEntities) {
                meetingInfoEntity.setMeetingName(meetingEntity.getTitle());
                meetingInfoEntity.setBeginTime(meetingEntity.getBegin_date());
                meetingInfoEntity.setEndTime(meetingEntity.getEnd_date());

                sql = "SELECT * FROM ORG_MEMBER WHERE ID=?";
                OrgMemberEntity orgMemberEntity = jdbcTemplate.queryForObject(
                        sql, new Object[]{meetingEntity.getCreate_user()},
                        new BeanPropertyRowMapper<>(OrgMemberEntity.class));
                if (orgMemberEntity != null &&
                    orgMemberEntity.getExt_attr_3() != null &&
                    orgMemberEntity.getOrg_department_id() != null) {
                    meetingInfoEntity.setUser(orgMemberEntity.getName());
                    meetingInfoEntity.setContact(orgMemberEntity.getExt_attr_3());
                    sql = "SELECT * FROM ORG_UNIT WHERE ID=?";
                    OrgUnitEntity orgEntity = jdbcTemplate.queryForObject(
                            sql, new Object[]{orgMemberEntity.getOrg_department_id()},
                            new BeanPropertyRowMapper<>(OrgUnitEntity.class));
                    if (orgEntity != null) {
                        meetingInfoEntity.setDepartment(orgEntity.getName());

                    }
                }
            }
            meetingInfoEntities.add(meetingInfoEntity);
        }

        return meetingInfoEntities;
    }
}