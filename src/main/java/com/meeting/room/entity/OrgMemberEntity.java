package com.meeting.room.entity;

import java.io.Serializable;

public class OrgMemberEntity {
    private Long id;                /* ID */
    private String name;            /* 人名 */
    private Long org_department_id; /* 部门ID */
    private String ext_attr_1;      /* 手机*/
    private String ext_attr_2;      /* 邮箱*/
    private String ext_attr_3;      /* */

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

    public Long getOrg_department_id() {
        return org_department_id;
    }

    public void setOrg_department_id(Long org_department_id) {
        this.org_department_id = org_department_id;
    }

    public String getExt_attr_1() {
        return ext_attr_1;
    }

    public void setExt_attr_1(String ext_attr_1) {
        this.ext_attr_1 = ext_attr_1;
    }

    public String getExt_attr_2() {
        return ext_attr_2;
    }

    public void setExt_attr_2(String ext_attr_2) {
        this.ext_attr_2 = ext_attr_2;
    }

    public String getExt_attr_3() {
        return ext_attr_3;
    }

    public void setExt_attr_3(String ext_attr_3) {
        this.ext_attr_3 = ext_attr_3;
    }
}
