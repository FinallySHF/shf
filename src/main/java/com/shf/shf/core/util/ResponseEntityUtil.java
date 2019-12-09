package com.shf.shf.core.util;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p><b>请求返回数据封装对象工具类</b></p>
 * 数据返回对象统一使用  org.springframework.http.ResponseEntity&lt;Map&lt;String, Object&gt;&gt;
 * 此类用于便捷封装生成该类对象
 * @author Chao.yy #2018年3月4日 下午9:31:06 
 * @version V1.0
 */
@ApiModel(description = "数据返回对象工具类")
public class ResponseEntityUtil {
    /**
     * 请求状态码
     */
    @ApiModelProperty(value = "请求状态码")
    public static final  String STATUS = "status";
    /**
     * 业务返回数据
     */
    @ApiModelProperty(value = "业务返回数据")
    public static final  String DATA = "data";
    /**
     * 原始错误信息
     */
    @ApiModelProperty(value = "原始错误信息")
    public static final  String ERROR = "error";
    /**
     * 错误信息描述
     */
    @ApiModelProperty(value = "错误信息描述")
    public static final  String MESSAGE = "message";
    /**
     * 错误详细信息
     */
    @ApiModelProperty(value = "错误详细信息")
    public static final  String DETAIL= "detail";
    /**
     * 备注额外信息
     */
    @ApiModelProperty(value = "备注额外信息")
    public static final  String NOTES= "notes";
    /**
     * 时间戳 
     */
    @ApiModelProperty(value = "时间戳")
    public static final  String TIMESTAMP = "timestamp";

    /**
     * <p><b>请求成功返回的封装方法</b></p>
     * @author Chao.yy #2018年3月4日 下午9:42:33 
     * @version V1.0
     * @param data
     * @return
     */
    public static ResponseEntity<Map<String, Object>> success(Object data) {
        Map<String, Object> body = new HashMap<String, Object>(3);
        body.put(STATUS, HttpStatus.OK.value());
        body.put(DATA, data);
        body.put(TIMESTAMP, new Date());
        ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<Map<String, Object>>(body,
            HttpStatus.OK);
        return responseEntity;
    }

    /**
     * <p><b>请求失败返回的封装方法</b></p>
     * <p>请求状态默认设置为false</p>
     * @author Chao.yy #2018年3月4日 下午9:42:03 
     * @version V1.0
     * @param status
     * @param error
     * @param message
     * @param detail
     * @param notes
     * @return
     */
    public static ResponseEntity<Map<String, Object>> failure(HttpStatus status, String error, String message,
        String detail, String notes) {
        Map<String, Object> body = new HashMap<String, Object>(6);
        body.put(STATUS, status.value());
        body.put(MESSAGE, message);
        body.put(ERROR, error);
        body.put(DETAIL, detail);
        body.put(NOTES, notes);
        body.put(TIMESTAMP, new Date());
        ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<Map<String, Object>>(body, status);
        return responseEntity;
    }

    /**
     * 
     * <p><b>请求失败抛出异常返回的封装方法</b></p>
     * @author Chao.yy  # 2018年06月22日 上午11:25:14
     * @version V1.0
     * @param status 状态码
     * @param message 异常信息中文描述
     * @param e 异常对象
     * @param notes 
     * @return
     *
     */
    public static ResponseEntity<Map<String, Object>> failure(HttpStatus status, String message, Exception e,
        String notes) {
        Map<String, Object> body = new HashMap<String, Object>(6);
        body.put(STATUS, status.value());
        body.put(MESSAGE, message);
        body.put(ERROR, e.getMessage());
        body.put(DETAIL, Arrays.toString(e.getStackTrace()));
        body.put(NOTES, notes);
        body.put(TIMESTAMP, new Date());
        ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<Map<String, Object>>(body, status);
        return responseEntity;
    }
}
