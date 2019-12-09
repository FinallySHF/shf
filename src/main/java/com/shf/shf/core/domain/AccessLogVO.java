package com.shf.shf.core.domain;

import java.util.Date;

/**
 * 
 * <p><b>系统请求日志实体对象</b></p>
 * @author Chao.yy  #2018年07月02日 下午4:04:12
 * @version V1.0
 *
 */
public class AccessLogVO {

    /**
     * 编号
     */
    private String id;
    /**
     * 客户端请求ip
     */
    private String clientIp;
    /**
     * 客户端请求路径
     */
    private String url;
    /**
     * 终端请求方式,普通请求,ajax请求
     */
    private String type;
    /**
     * 请求方式method,post,get等
     */
    private String method;
    /**
     * 请求的类及方法
     */
    private String classMethod;
    /**
     * 请求参数内容,json
     */
    private String paramData;
    /**
     * 请求接口唯一session标识
     */
    private String sessionId;
    /**
     * 请求接口唯一session标识
     */
    private String userId;
    /**
     * 请求时间
     */
    private Date time;
    /**
     * 接口返回时间
     */
    private Date returnTime;
    /**
     * 接口返回数据json
     */
    private String returnData;
    /**
     * 请求时httpStatusCode代码，如：200,400,404等
     */
    private Integer status;
    /**
     * 请求耗时秒单位
     */
    private Long timeConsuming;
    /**
     * 异常描述
     */
    private String exceptionMessage;
    /**
     * 请求开始时间
     */
    private Long startTime;
    /**
     * 请求结束时间
     */
    private Long endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(long timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
        this.setTime(new Date(startTime));
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
        this.setReturnTime(new Date(endTime));
    }

    @Override
    public String toString() {
        return "AccessLogVO [id=" + id + ", clientIp=" + clientIp + ", url=" + url + ", type=" + type + ", method="
            + method + ", classMethod=" + classMethod + ", paramData=" + paramData + ", sessionId=" + sessionId
            + ", userId=" + userId + ", time=" + time + ", returnTime=" + returnTime + ", returnData=" + returnData
            + ", status=" + status + ", timeConsuming=" + timeConsuming + ", exceptionMessage=" + exceptionMessage
            + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }
}