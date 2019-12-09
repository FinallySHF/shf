package com.shf.shf.core.util;

import javax.servlet.http.HttpServletRequest;

/**
 * <p><b>请求工具类</b></p>
 * 主要从request获取相应参数
 * @author Chao.yy  #2018年07月02日 下午6:33:04
 * @version V1.0
 * 
 */
public class RequestUtil {
    
    /**
     *    
     * <p><b>获取客户端IP</b></p>
     * @author Chao.yy #2018年3月13日 下午10:22:34 
     * @version V1.0
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String unknown = "unknown";
        String forwarded = "x-forwarded-for";
        String proxyClient = "Proxy-Client-IP";
        String wlProxyClient = "WL-Proxy-Client-IP";
        String httpCLIENT = "HTTP_CLIENT_IP";
        String httpForwarded = "HTTP_X_FORWARDED_FOR";
        String ip = request.getHeader(forwarded);
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader(proxyClient);
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader(wlProxyClient);
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader(httpCLIENT);
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader(httpForwarded);
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 多个路由时，取第一个非unknown的ip
        String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!unknown.equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
        return ip;
    }
    
    /**
     * 获取请求类型
     * @param request
     * @return
     */
    public static String getRequestType(HttpServletRequest request) {
        return request.getHeader("X-Requested-With");
    }
}
