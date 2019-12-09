package com.shf.shf.dao;

import com.shf.shf.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p><b>hrDao</b></p>
 *
 * @author sun.hf #2018年3月13日 下午10:34:40
 * @version V1.0
 */
@Mapper
public interface SysUserRoleDao {
    List<SysUserRole> listByUserId(Integer userId);
}
