package com.macro.mall.tiny.service;

import com.macro.mall.tiny.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * 会员浏览记录管理service
 * @Author zfj
 * @create 2021/6/15 12:21
 */
public interface MemberReadHistoryService {
    /*
    * 生成浏览记录
    * */
    int create(MemberReadHistory memberReadHistory);
    /*
    * 批量删除浏览记录
    * */
    int delete(List<String> ids);
    /*
    * 根据用户浏览历史记录
    * */
    List<MemberReadHistory> list(Long memberId);

}
