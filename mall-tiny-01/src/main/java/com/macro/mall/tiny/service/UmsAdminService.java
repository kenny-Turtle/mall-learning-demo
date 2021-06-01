package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsPermission;

import java.util.List;

/**
* @Description: 后台管理员Service
* @Author: Jay
* @Date: 2021/5/5 4:30 下午
*/
public interface UmsAdminService {

    /*
    * 根据用户名获取后台管理员
    * */
    UmsAdmin getAdminByUsername(String username);

    /*
    * 注册功能
    * */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
    * @Description: 登陆功能
    * @Param: [username, password]
    * @return: java.lang.String
    * @Author: Jay
    * @Date: 2021/5/5 4:58 下午
    */
    String login(String username,String password);

    /*
    * 获取用户所有权限（包括角色权限+-功能）
    * */
    List<UmsPermission> getPermissionList(Long adminId);
}
