package com.shf.shf.service.impl;

import com.shf.shf.dao.SysUserDao;
import com.shf.shf.dao.SysUserRoleDao;
import com.shf.shf.domain.SysUser;
import com.shf.shf.service.SysUserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p><b>hrDao</b></p>
 *
 * @author sun.hf #2018年3月13日 下午10:34:40
 * @version V1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    public SysUserDao sysUserDao;

    public SysUser selectById(Integer id) {
        return sysUserDao.selectById(id);
    }


    public SysUser selectByName(String name) {
        return sysUserDao.selectByName(name);
    }

}
