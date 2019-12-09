package com.shf.shf.domain;


import io.swagger.annotations.ApiModel;

/**
 * <p><b>hr实体类</b></p>
 *
 * @author sun.hf  #2018年06月04日 下午2:53:18
 * @version V1.0
 */
@ApiModel(description = "user_role")
public class SysUserRole implements java.io.Serializable {
    static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}