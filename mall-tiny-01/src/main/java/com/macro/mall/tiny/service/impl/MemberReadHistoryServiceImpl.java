package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.macro.mall.tiny.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.macro.mall.tiny.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 会员浏览记录管理service实现类
 * @Author zfj
 * @create 2021/6/15 12:24
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;
    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deletedList = new ArrayList<>();
        for(String id : ids){
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deletedList.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deletedList);
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
//        return memberReadHistoryRepository.findByMemberIdOrOrderByCreateTimeDesc(memberId);
        return  memberReadHistoryRepository.findAll();
    }
}
