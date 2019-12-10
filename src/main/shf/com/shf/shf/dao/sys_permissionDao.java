package com.shf.shf.dao;

import com.shf.shf.core.dao.BaseDao;
import com.shf.shf.domain.sys_permissionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p><b>sys_permissionDao</b></p>
 *
 * @author sun.hf #2018年3月13日 下午10:34:40
 * @version V1.0
 */
@Mapper
public interface sys_permissionDao extends BaseDao<sys_permissionVO, String> {
    List<sys_permissionVO> listByRoleId(Integer roleId);
}
