package com.shf.shf.domain;


import com.shf.shf.core.dao.PropertyMapper;
import io.swagger.annotations.ApiModel;

/**
 * <p><b>hr实体类</b></p>
 *
 * @author sun.hf  #2018年06月04日 下午2:53:18
 * @version V1.0
 */
@ApiModel(description = "user")
public class SysUser implements java.io.Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}