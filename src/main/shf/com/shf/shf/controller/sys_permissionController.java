package com.shf.shf.controller;

import com.github.pagehelper.PageInfo;
import com.shf.shf.core.util.ResponseEntityUtil;
import com.shf.shf.domain.sys_permissionVO;
import com.shf.shf.service.sys_permissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * <p><b>sys_permission控制器</b></p>
 * @author sun.hf  #2018年06月02日 下午1:06:46
 * @version V1.0
 */
 
@RestController
@RequestMapping("shf/sys_permission")
@Api(tags = { "sys_permission管理" })
public class sys_permissionController {
    @Autowired
    private sys_permissionService service;


    @GetMapping(value = "/{id}")
    @ApiOperation("获取单条记录信息")
    public ResponseEntity<Map<String, Object>> queryByKey(@PathVariable String id) {
        sys_permissionVO vo = service.queryByKey(id);
        return ResponseEntityUtil.success(vo);
    }

    @GetMapping
    @ApiOperation("获取全表数据")
    public ResponseEntity<Map<String, Object>> list() {
        List<sys_permissionVO> list = service.queryList();
        return ResponseEntityUtil.success(list);
    }

    @PostMapping(value = "listByPage")
    @ApiOperation("查询列表-支持分页/参数")
    public ResponseEntity<Map<String, Object>> listByPage(@RequestParam(defaultValue = "1") int pageNum,
        @RequestParam(defaultValue = "15") int pageSize, @RequestBody Map<String, String> params) {
        PageInfo<sys_permissionVO> pageInfo = service.queryListByPage(pageNum, pageSize, params);
        return ResponseEntityUtil.success(pageInfo);
    }

    @PostMapping
    @ApiOperation("新增记录")
    public ResponseEntity<Map<String, Object>> save(sys_permissionVO t) {
        service.save(t);
        return ResponseEntityUtil.success(t);
    }

    @PutMapping
    @ApiOperation("修改记录")
    public ResponseEntity<Map<String, Object>> update(sys_permissionVO t) {
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
