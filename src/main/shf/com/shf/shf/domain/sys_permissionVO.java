package com.shf.shf.domain;


import com.shf.shf.core.dao.PropertyMapper;
import io.swagger.annotations.ApiModel;

import java.util.Arrays;
import java.util.List;

/**
 * <p><b>sys_permission实体类</b></p>
 *
 * @author sun.hf  #2018年06月04日 下午2:53:18
 * @version V1.0
 */
@ApiModel(description = "sys_permission对象")
public class sys_permissionVO implements java.io.Serializable, PropertyMapper {


    private static final long serialVersionUID = 1L;

    private Integer id;
    private String url;
    private Integer roleId;
    private String permission;
    private List permissions;

    public List getPermissions() {
        return Arrays.asList(this.permission.trim().split(","));
    }

    public void setPermissions(List permissions) {
        this.permissions = permissions;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String getPropertyMapper(String property) {
        String columnName = null;
        switch (property) {
            case "id":
                columnName = "id";
                break;
            case "url":
                columnName = "url";
                break;
            case "roleId":
                columnName = "role_id";
                break;
            case "permission":
                columnName = "permission";
                break;
            default:
                columnName = null;
                break;
        }
        return columnName;
    }
}