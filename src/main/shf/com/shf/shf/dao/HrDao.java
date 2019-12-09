package com.shf.shf.dao;
 
import com.shf.shf.core.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import com.shf.shf.domain.HrVO;

/**
 * 
 * <p><b>hrDao</b></p>
 * @author sun.hf #2018年3月13日 下午10:34:40 
 * @version V1.0
 */
@Mapper
public interface HrDao extends BaseDao<HrVO, String> {

}
