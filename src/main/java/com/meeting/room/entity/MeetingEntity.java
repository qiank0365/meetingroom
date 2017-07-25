package com.meeting.room.entity;

import java.io.Serializable;

public class MeetingEntity implements Serializable {
    private String id;           /* ID */
    private String title;        /* 会议名称 */
    private Integer state;       /* 会议状态 */
    private Long create_user;    /* 预定人ID */
    private Long account_id;     /* 部门ID */
    private String tel;          /* 联系方式 */
    private String begin_date;   /* 开始时间 */
    private String end_date;     /* 开始时间 */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreate_user() {
        return create_user;
    }

    public void setCreate_user(Long create_user) {
        this.create_user = create_user;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
