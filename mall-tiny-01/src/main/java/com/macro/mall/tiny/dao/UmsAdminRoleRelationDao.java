package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色自定义dao
 * @Author zfj
 * @create 2021/6/4 16:41
 */
public interface UmsAdminRoleRelationDao {
    /*
    * 获取用户所有权限
    * */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
