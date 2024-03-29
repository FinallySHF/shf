package com.shf.shf.controller;

import java.util.List;
import java.util.Map;

import com.shf.shf.core.util.ResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.shf.shf.domain.HrVO;
import com.shf.shf.service.HrService;


/**
 * <p><b>hr控制器</b></p>
 *
 * @author sun.hf  #2018年06月02日 下午1:06:46
 * @version V1.0
 */

@RestController
@RequestMapping("shf/hr")
@Api(tags = {"hr管理"})
public class HrController {
    @Autowired
    private HrService service;


    @GetMapping(value = "/{id}")
    @ApiOperation("获取单条记录信息")
    public ResponseEntity<Map<String, Object>> queryByKey(@PathVariable String id) {
        HrVO vo = service.queryByKey(id);
        return ResponseEntityUtil.success(vo);
    }

    @GetMapping
    @ApiOperation("获取全表数据")
    public ResponseEntity<Map<String, Object>> list() {
        List<HrVO> list = service.queryList();
        return ResponseEntityUtil.success(list);
    }

    @PostMapping(value = "listByPage")
    @ApiOperation("查询列表-支持分页/参数")
    public ResponseEntity<Map<String, Object>> listByPage(@RequestParam(defaultValue = "1") int pageNum,
                                                          @RequestParam(defaultValue = "15") int pageSize, @RequestBody Map<String, String> params) {
        PageInfo<HrVO> pageInfo = service.queryListByPage(pageNum, pageSize, params);
        return ResponseEntityUtil.success(pageInfo);
    }

    @PostMapping
    @ApiOperation("新增记录")
    public ResponseEntity<Map<String, Object>> save(HrVO t) {
        service.save(t);
        return ResponseEntityUtil.success(t);
    }

    @PutMapping
    @ApiOperation("修改记录")
    public ResponseEntity<Map<String, Object>> update(HrVO t) {
        service.updateByKeySelective(t);
        return ResponseEntityUtil.success(t);
    }

    @DeleteMapping
    @ApiOperation("删除记录")
    public ResponseEntity<Map<String, Object>> remove(String id) {
        return ResponseEntityUtil.success(service.remove(id));
    }

    @DeleteMapping(value = "removeForBatch")
    @ApiOperation("删除多条记录")
    public ResponseEntity<Map<String, Object>> removeForBatch(String[] ids) {
        return ResponseEntityUtil.success(service.removeForBatch(ids));
    }
}
