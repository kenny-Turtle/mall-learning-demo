package com.macro.mall.tiny.service;
/**
* @Description: redis操作Service
 * 对象和数组都以json形式进行存储
* @Author: Jay
* @Date: 2021/4/25 3:11 下午
*/
public interface RedisService {

    /**
    * @Description: 存储数据
    * @Author: Jay
    * @Date: 2021/4/25 3:12 下午
    */
    void set(String key,String value);

    /**
    * @Description:
    * @Author: Jay
    * @Date: 2021/4/25 3:12 下午
    */
    String get(String key);

    /**
    * @Description: 设置过期时间
    * @Author: Jay
    * @Date: 2021/4/25 3:27 下午
    */
    boolean explire(String key,long expire);

    /**
    * @Description: 删除数据
    * @Author: Jay
    * @Date: 2021/4/25 3:31 下午
    */
    void remove(String key);

    /**
    * @Description: 自增操作
    * @Author: Jay
    * @Date: 2021/4/25 3:31 下午
    */
    Long increment(String key,long delta);
}
