package com.macro.mall.tiny.service;

import com.macro.mall.tiny.dto.OssCallBackParam;
import com.macro.mall.tiny.dto.OssCallbackResult;
import com.macro.mall.tiny.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**Oss上传管理service
 * @Author zfj
 * @create 2021/6/21 13:36
 */
public interface OssService {

    /*
    * oss上传策略生成
    * */
    OssPolicyResult policy();
    /*
    * oss上传成功回调
    * */
    OssCallbackResult callback(HttpServletRequest request);
}
