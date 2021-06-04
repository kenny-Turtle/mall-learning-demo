package com.macro.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 * @Author zfj
 * @create 2021/6/4 15:54
 */
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "用户名",required = true)
    @NotEmpty
    private String username;

    @ApiModelProperty(value = "密码",required = true)
    @NotEmpty
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
