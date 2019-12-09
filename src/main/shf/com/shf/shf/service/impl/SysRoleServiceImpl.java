package com.shf.shf.service.impl;

import com.shf.shf.dao.SysRoleDao;
import com.shf.shf.domain.SysRole;
import com.shf.shf.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p><b>SysRoleDao</b></p>
 *
 * @author sun.hf #2018年3月13日 下午10:34:40
 * @version V1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    public SysRoleDao sysRoleDao;

    public SysRole selectById(Integer id) {
        return sysRoleDao.selectById(id);
    }

}
