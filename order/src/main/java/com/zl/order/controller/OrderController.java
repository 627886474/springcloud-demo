package com.zl.order.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zl.order.client.ProductClient;
import com.zl.order.dto.OrderDTO;
import com.zl.order.dto.ResultVo;
import com.zl.order.dto.productcommon.DecreaseStockInput;
import com.zl.order.dto.productcommon.ProductInfoOutput;
import com.zl.order.enums.OrderStatusEnum;
import com.zl.order.enums.ResultEnum;
import com.zl.order.model.OrderDetail;
import com.zl.order.service.OrderService;
import com.zl.order.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: le
 * @Date: 2018/7/24 17:27
 * @Description:
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;

    @PostMapping("/create")
    @ResponseBody
    public Object createController(@RequestBody Map<String,Object> reqMap){

        //获取参数
        String buyerName = reqMap.get("buyer_name").toString();
        String buyerPhone = reqMap.get("buyer_phone").toString();
        String buyerAddress = reqMap.get("buyer_address").toString();
        String buyerOpenId = reqMap.get("buyer_openId").toString();

        //订单详情item里面包含orderdetail
        Object items = reqMap.get("item");

        if (buyerName == null || buyerPhone == null || buyerAddress == null) {
            return ResultUtil.badArgumentValue();
        }
        try {
            //对象转string
            String itemsString = JSON.toJSONString(items);
            //string再相关对象到Java实体
            List<OrderDetail> orderDetailList = JSONObject.parseArray(itemsString, OrderDetail.class);
            try {
                OrderDTO orderDto = new OrderDTO();
                orderDto.setBuyerName(buyerName);
                orderDto.setBuyerPhone(buyerPhone);
                orderDto.setBuyerAddress(buyerAddress);
                orderDto.setBuyerOpenid(buyerOpenId);
                orderDto.setOrderDetailList(orderDetailList);
                //创建订单
                OrderDTO createResult = orderService.createOrder(orderDto);

                Map<String, Object> map = new HashMap<>();
                map.put("order_id", createResult.getOrderId());
                return ResultUtil.ok(map);
            } catch (Exception e) {
                return ResultUtil.fail(e.getMessage());
            }
        } catch (Exception e) {
            return ResultUtil.badArgument();
        }}
    /*order调用product测试*/
    @GetMapping("/getProdutMsg")
    public String getProductMsg(){
        String response =productClient.productMsg();
        return response;
    }
    /*order调用product商品展示接口测试*/
    @PostMapping("/getlistForOrder")
    @ResponseBody
    public Object listForOrder(@RequestBody List<String> productIdList){
        List<ProductInfoOutput> resultVo=productClient.listForOrder(productIdList);
        return ResultUtil.success(resultVo);
    }

    /*order调用product扣库存接口测试*/
    @PostMapping("/updateProductQuantity")
    public void updateProductQuantity(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productClient.decreaseStock(decreaseStockInputList);
    }


}
