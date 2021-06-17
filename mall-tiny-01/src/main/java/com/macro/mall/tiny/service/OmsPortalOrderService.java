package com.macro.mall.tiny.service;

import com.github.pagehelper.parser.OrderByParser;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理service
 * @Author zfj
 * @create 2021/6/17 15:08
 */
public interface OmsPortalOrderService {
    /*
    * 根据提交信息生成订单
    * */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /*
    * 取消订单
    * */
    @Transactional
    void cancelOrder(Long orderId);
}
