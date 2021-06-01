package com.macro.mall.tiny.service;

import com.macro.mall.tiny.common.api.CommonResult;

/**
* @Description: 会员管理service
* @Author: Jay
* @Date: 2021/4/25 3:51 下午
*/
public interface UmsMemberService {

    /**
    * @Description: 生成验证码
    * @Author: Jay
    * @Date: 2021/4/25 3:52 下午
    */
    CommonResult generateAuthCode(String telephone);

    /**
    * @Description: 判断验证码和手机号码是否匹配
    * @Author: Jay
    * @Date: 2021/4/25 3:52 下午
    */
    CommonResult verifyAuthCode(String telephone,String authCode);
}
