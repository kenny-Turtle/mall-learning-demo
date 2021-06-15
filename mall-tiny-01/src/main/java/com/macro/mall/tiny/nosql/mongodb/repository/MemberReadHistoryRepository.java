package com.macro.mall.tiny.nosql.mongodb.repository;

import com.macro.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 会员商城浏览历史记录
 * @Author zfj
 * @create 2021/6/15 12:18
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /*
    * 根据会员id按照时间倒序获取浏览记录
    * */
//    List<MemberReadHistory> findByMemberIdOrOrderByCreateTimeDesc(Long memberId);
}
