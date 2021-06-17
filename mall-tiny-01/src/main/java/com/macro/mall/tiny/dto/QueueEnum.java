package com.macro.mall.tiny.dto;

import lombok.Getter;

/**
 * 用于延迟消息队列及处理取消订单消息队列的常量定义，包括交换机名称、队列名称、路由键名称
 * 消息队列枚举配置
 * @Author zfj
 * @create 2021/6/17 13:54
 */
@Getter
public enum QueueEnum {
    /*
    * 消息通知队列
    * */
    QUEUE_ORDER_CANCEL("mall.order.direct","mall.order.cancel","mall.order.cancel"),

    /*
    * 消息通知ttl队列
    * */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl","mall.order.cancel.ttl","mall.order.cancel.ttl");

    /*
    * 交换名称
    * */
    private String exchange;
    /*
    * 队列名称
    * */
    private String name;
    /*
    * 路由键名称
    * */
    private String routeKey;

    QueueEnum(String excahnge,String name,String routeKey){
        this.exchange = excahnge;
        this.name = name;
        this.routeKey = routeKey;
    }

}
