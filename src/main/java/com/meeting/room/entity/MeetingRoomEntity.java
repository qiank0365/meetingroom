package com.meeting.room.entity;

import java.io.Serializable;

public class MeetingRoomEntity implements Serializable {
    /* 会议室ID */
    private Long id;
    /* 会议室名称 */
    private String name;
    /* 会议室地点 */
    //private String place;

    //private String description;
    /* 可容纳人数 */
    //private Integer seatCount;
    /* 是否需要申请 */
    //private Short needApp;

    //private Short status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public Short getNeedApp() {
        return needApp;
    }

    public void setNeedApp(Short needApp) {
        this.needApp = needApp;
    }
*/
    /*public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }*/
}
