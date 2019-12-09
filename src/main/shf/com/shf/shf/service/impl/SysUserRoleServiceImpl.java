package com.shf.shf.service.impl;


import com.shf.shf.dao.SysUserRoleDao;
import com.shf.shf.domain.SysUserRole;
import com.shf.shf.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p><b>hrDao</b></p>
 *
 * @author sun.hf #2018年3月13日 下午10:34:40
 * @version V1.0
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    public SysUserRoleDao sysUserRoleDao;

    public List<SysUserRole> listByUserId(Integer userId) {
        return sysUserRoleDao.listByUserId(userId);
    }

}
