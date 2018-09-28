package com.zl.product.dao;

import com.zl.product.model.ProductCategory;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2018/7/15 17:02
 * @Description:
 */
public interface ProductCategoryDao {

    /**
     * 通过类别查询
     * @param categiryListType
     * @return
     */
    List<ProductCategory> findProductCategoryByType(List<Integer> categiryListType);

}
