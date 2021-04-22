package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/*
* PmsBrandService
* */
public interface PmsBrandService {

    //显示所有品牌brand
    List<PmsBrand> listAllBrand();

    //新增
    int createBrand(PmsBrand brand);

    //修改
    int updateBrand(Long id,PmsBrand brand);

    //删除
    int deleteBrand(Long id);

    //获取某页数据
    List<PmsBrand> listBrand(int pageNum,int pageSize);

    //根据id获取数据
    PmsBrand getBrand(Long id);
}
