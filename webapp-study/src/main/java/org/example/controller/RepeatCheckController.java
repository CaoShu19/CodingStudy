package org.example.controller;

import org.example.model.TOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : Str2ke
 * @date : 2024/2/28 上午1:45
 * @Desc :
 */
@RestController
public class RepeatCheckController {

    /**
     * 实现业务:根据某一属性来判断参数是否重复
     * @param orderList
     * @return
     */
    /** test case:127.0.0.1:8080/shop/add
     * [
     *     {
     *         "orderId":"1",
     *         "orderType":1,
     *         "name":"aa"
     *     },
     *     {
     *         "orderId":"1",
     *         "orderType":1,
     *         "name":"aa"
     *     }
     * ]
     */
    @PostMapping("/shop/add")
    public String addShop(@RequestBody List<TOrder> orderList) {

        String repeatName = orderList.stream().collect(Collectors.groupingBy(TOrder::getName, Collectors.counting()))
                .entrySet().stream().filter(v -> v.getValue() > 1L).map(Map.Entry::getKey)
                .findAny().orElse(null);
        if (repeatName != null) {
            System.out.println("repeat:" + repeatName);
        }
        return "ok";
    }
}
