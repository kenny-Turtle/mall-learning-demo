package com.macro.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户登陆参数
 * @author Jay
 * @date 2021/5/31 2:43 下午
 */
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
