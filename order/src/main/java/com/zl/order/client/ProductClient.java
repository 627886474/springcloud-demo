package com.zl.order.client;

import com.zl.order.dto.productcommon.DecreaseStockInput;
import com.zl.order.dto.productcommon.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2018/9/26 22:21
 * @Description:
 */
@FeignClient(name = "product")
public interface ProductClient {
    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

    @GetMapping("/msg")
    String productMsg();

}
