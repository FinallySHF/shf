package com.shf.shf.service.impl;

import com.shf.shf.core.dao.BaseDao;
import com.shf.shf.core.service.impl.BaseServiceImpl;
import com.shf.shf.dao.sys_permissionDao;
import com.shf.shf.domain.sys_permissionVO;
import com.shf.shf.service.sys_permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p><b>sys_permission服务接口</b></p>
 *
 * @author sun.hf #2018年3月13日 下午6:04:16
 * @version V1.0
 */
@Service
public class sys_permissionServiceImpl extends BaseServiceImpl<sys_permissionVO, String> implements sys_permissionService {
    @Autowired
    private sys_permissionDao dao;

    @Override
    public BaseDao<sys_permissionVO, String> getDao() {
        return dao;
    }

    @Override
    public List<sys_permissionVO> listByRoleId(Integer roleId) {
        return dao.listByRoleId(roleId);
    }
}

