package com.shf.shf.service.impl;

import com.shf.shf.core.dao.BaseDao;
import com.shf.shf.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.shf.shf.dao.HrDao;
import com.shf.shf.domain.HrVO;
import com.shf.shf.service.HrService;

/**
 * <p><b>hr服务接口</b></p>
 *
 * @author sun.hf #2018年3月13日 下午6:04:16
 * @version V1.0
 */
@Service
public class HrServiceImpl extends BaseServiceImpl<HrVO, String> implements HrService {
    @Autowired
    private HrDao dao;

    @Override
    public BaseDao<HrVO, String> getDao() {
        return dao;
    }
}

