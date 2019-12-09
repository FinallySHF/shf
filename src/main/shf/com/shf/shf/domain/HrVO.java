package com.shf.shf.domain;


import com.shf.shf.core.dao.PropertyMapper;
import io.swagger.annotations.ApiModel;

/**
 * <p><b>hr实体类</b></p>
 *
 * @author sun.hf  #2018年06月04日 下午2:53:18
 * @version V1.0
 */
@ApiModel(description = "hr对象")
public class HrVO implements java.io.Serializable, PropertyMapper {


    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String phone;
    private String telephone;
    private String address;
    private Integer enabled;
    private String username;
    private String password;
    private String userface;
    private String remark;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserface() {
        return this.userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getPropertyMapper(String property) {
        String columnName = null;
        switch (property) {
            case "id":
                columnName = "id";
                break;
            case "name":
                columnName = "name";
                break;
            case "phone":
                columnName = "phone";
                break;
            case "telephone":
                columnName = "telephone";
                break;
            case "address":
                columnName = "address";
                break;
            case "enabled":
                columnName = "enabled";
                break;
            case "username":
                columnName = "username";
                break;
            case "password":
                columnName = "password";
                break;
            case "userface":
                columnName = "userface";
                break;
            case "remark":
                columnName = "remark";
                break;
            default:
                columnName = null;
                break;
        }
        return columnName;
    }
}