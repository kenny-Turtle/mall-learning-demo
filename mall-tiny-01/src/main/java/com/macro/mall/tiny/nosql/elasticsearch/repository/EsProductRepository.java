package com.macro.mall.tiny.nosql.elasticsearch.repository;

import com.macro.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 商品ES操作类
 * @Author zfj
 * @create 2021/6/11 15:51
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {
    /*
    * 搜索名称
    * name  商品名称
    * subTitle  商品标题
    * keywords  商品关键词
    * page  分页信息
    * */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keyword, Pageable page);

}
