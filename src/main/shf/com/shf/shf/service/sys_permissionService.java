package com.shf.shf.service;

import com.shf.shf.core.service.BaseService;
import com.shf.shf.domain.sys_permissionVO;

import java.util.List;

/**
 * <p><b>sys_permission服务接口</b></p>
 *
 * @author sun.hf #2018年3月13日 下午6:04:16
 * @version V1.0
 */

public interface sys_permissionService extends BaseService<sys_permissionVO, String> {

    List<sys_permissionVO> listByRoleId(Integer roleId);
}
