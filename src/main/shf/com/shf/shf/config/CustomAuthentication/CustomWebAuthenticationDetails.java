package com.shf.shf.config.CustomAuthentication;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取用户登录时携带的额外信息
 * 自定义额外信息可添加多个，第一步常见details
 * 然后创建CustomAuthenticationProvider去登录认证，存放user信息
 * 然后将CustomAuthenticationProvider放入CustomAuthenticationDetailsSource
 * 最后在WebSecurityConfig中配置相关权限验证
 * --CustomWebAuthenticationDetails--CustomAuthenticationProvider
 * --CustomAuthenticationDetailsSource--WebSecurityConfig
 *
 *
 * @author sun.hf
 * @since 2018/5/9 11:15
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    private static final long serialVersionUID = 6975601077710753878L;
    private final String verifyCode;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        // verifyCode为页面中验证码的name
        verifyCode = request.getParameter("verifyCode");
    }

    public String getVerifyCode() {
        return this.verifyCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("; VerifyCode: ").append(this.getVerifyCode());
        return sb.toString();
    }
}
