package com.zl.product.service;

import com.zl.product.model.ProductCategory;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2018/7/15 17:34
 * @Description:
 */
public interface ProductCategoryService {

    /**
     * 通过商品类别查找
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
