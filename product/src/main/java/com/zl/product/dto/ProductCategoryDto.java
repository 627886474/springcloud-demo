package com.zl.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zl.product.model.ProductInfo;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2018/7/15 17:21
 * @Description:
 */

/**
 * 给用户展示的商品类别的  试图类
 * JsonProperty，控制返回的json的key
 * 在代码中使用categoryName为了更加方便理解，但是返回的json任然是name
 */
public class ProductCategoryDto {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<ProductInfoDto> productInfoDtoList;

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public List<ProductInfoDto> getProductInfoDtoList() {
        return productInfoDtoList;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public void setProductInfoDtoList(List<ProductInfoDto> productInfoDtoList) {
        this.productInfoDtoList = productInfoDtoList;
    }
}
