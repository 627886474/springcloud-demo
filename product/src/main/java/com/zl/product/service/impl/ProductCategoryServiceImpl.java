package com.zl.product.service.impl;

import com.zl.product.dao.ProductCategoryDao;
import com.zl.product.model.ProductCategory;
import com.zl.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2018/7/15 17:34
 * @Description:
 */

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    /**
     * 通过商品类别查找
     * @param categoryTypeList
     * @return
     */
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        List<ProductCategory> productCategoryList = productCategoryDao.findProductCategoryByType(categoryTypeList);
        return productCategoryList;
    }
}
