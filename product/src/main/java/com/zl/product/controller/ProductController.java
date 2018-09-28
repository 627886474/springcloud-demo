package com.zl.product.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zl.product.common.DecreaseStockInput;
import com.zl.product.common.ProductInfoOutput;
import com.zl.product.dto.ProductCategoryDto;
import com.zl.product.dto.ProductInfoDto;
import com.zl.product.dto.Result;
import com.zl.product.model.ProductCategory;
import com.zl.product.model.ProductInfo;
import com.zl.product.service.ProductCategoryService;
import com.zl.product.service.ProductService;
import com.zl.product.utils.ResultUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: le
 * @Date: 2018/7/15 16:33
 * @Description:
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 商品信息
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public Result<ProductInfoDto> productList(){
        //查询在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //获取类目的type集合
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType )
                .collect(Collectors.toList());
        //查询类目
        System.out.println(categoryTypeList.get(0));
        List<ProductCategory> categoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //构造返回的数据
        List<ProductCategoryDto> productCategoryDtoList = new ArrayList<>();
        //分类的数据
        for (ProductCategory productCategory:categoryList){
            ProductCategoryDto productCategoryDto = new ProductCategoryDto();
            productCategoryDto.setCategoryName(productCategory.getCategoryName());
            productCategoryDto.setCategoryType(productCategory.getCategoryType());
            //商品数据
            List<ProductInfoDto> productInfoDtoList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoDto productInfoDto = new ProductInfoDto();
                    BeanUtils.copyProperties(productInfo,productInfoDto);
                    productInfoDtoList.add(productInfoDto);
                }
            }
            productCategoryDto.setProductInfoDtoList(productInfoDtoList);
            productCategoryDtoList.add(productCategoryDto);
        }
        return ResultUtils.success(productCategoryDtoList);
    }

    @PostMapping("/listForOrder")
    @ResponseBody
    public List<ProductInfoOutput> listForAll(@RequestBody List<String> productIdList){

//        String productIdString = JSON.toJSONString(reqMap.get("productIdList"));
//        List<String> productIds = JSONObject.parseArray(productIdString,String.class);

        List<ProductInfoOutput> productInfoOutputs = productService.findList(productIdList);
        return productInfoOutputs;
    }


    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
//        String decreaseStockInputsString = JSON.toJSONString(reqMap.get("decreaseStockInputList"));
//        List<DecreaseStockInput> decreaseStockInputs = JSONObject.parseArray(decreaseStockInputsString,DecreaseStockInput.class);

        productService.decreaseStockProcess(decreaseStockInputList);
    }


}
