package com.zl.product.service;

import com.zl.product.ProductApplication;
import com.zl.product.model.ProductCategory;
import com.zl.product.model.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: le
 * @Date: 2018/7/16 15:10
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class)
public class ProductCategoryTest {
    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    ProductService productService;


    /**
     * 通过商品类别查找 测试类
     */
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> categoryTypeList = Arrays.asList(11,22);
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductInfo> productInfoList = productService.findUpAll();
        System.out.println(productInfoList.get(0).getProductName());
    }

}
