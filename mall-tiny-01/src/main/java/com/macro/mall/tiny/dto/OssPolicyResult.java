package com.macro.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;

/**添加OSS上传策略封装对象
 * 前端直接上传文件时需要的参数，从后端直接返回过来
 * @Author zfj
 * @create 2021/6/21 13:14
 */
public class OssPolicyResult {
    @ApiModelProperty("访问身份验证中用到的用户标识")
    private String accessKeyId;
    @ApiModelProperty("用户表单上传的策略，经过base64编译过的字符串")
    private String policy;
    @ApiModelProperty("对policy签名后的字符串")
    private String signture;
    @ApiModelProperty("上传文件夹路径前缀")
    private String dir;
    @ApiModelProperty("oss对外服务的访问域名")
    private String host;
    @ApiModelProperty("上传成功后的回调设置")
    private String callback;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSignture() {
        return signture;
    }

    public void setSignture(String signture) {
        this.signture = signture;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
