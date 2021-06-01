package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.UmsAdminLoginParam;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsPermission;
import com.macro.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**后台用户管理
 * @author Jay
 * @date 2021/5/5 4:24 下午
 */
@Controller
@Api(tags = "UmsAdminController",description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    //用户注册
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdmin> register(@RequestParam UmsAdmin umsAdminParam, BindingResult result){
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if(umsAdmin ==  null){
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    //登陆以后返回token
    @ApiOperation(value = "登陆以后返回token")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam,BindingResult result){
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if(token == null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success(tokenMap);
    }

    //获取用户所有权限（包括+-权限）
    @ApiOperation(value = "获取用户所有的权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId){
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
}
