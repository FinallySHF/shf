package com.shf.shf.dao;

import com.shf.shf.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p><b>hrDao</b></p>
 *
 * @author sun.hf #2018年3月13日 下午10:34:40
 * @version V1.0
 */
@Mapper
public interface SysUserDao {
    SysUser selectById(Integer id);

    SysUser selectByName(String name);
}
