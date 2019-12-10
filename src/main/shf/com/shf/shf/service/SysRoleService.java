package com.shf.shf.service;

import com.shf.shf.domain.SysRole;

/**
 * <p><b>SysRoleDao</b></p>
 *
 * @author sun.hf #2018年3月13日 下午10:34:40
 * @version V1.0
 */
public interface SysRoleService {

    SysRole selectById(Integer id);

    SysRole selectByName(String name);
}
