package org.example.controller;

import com.google.gson.Gson;
import org.example.model.TOrder;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

/**
 * @author : Str2ke
 * @date : 2023/12/6 上午1:35
 * @Desc :
 */

@RestController
public class TestController {


    @PostMapping("order/adds")
    public String orderAdd(@RequestBody @Validated TOrder order) {
        System.out.println(new Gson().toJson(order));
        return new Gson().toJson(order);
    }

    @GetMapping("order/adds/test/retry")
    @Retryable(value = Exception.class, maxAttempts = 4, backoff = @Backoff(delay = 2000, multiplier = 2))
    public String retryMethod(@RequestParam Integer code) throws Exception {
        System.out.println("curTime:" + System.currentTimeMillis());
        if (code == 0) {
            throw new Exception("you will retry");
        }
        System.out.println("method be called and success");
        return new Gson().toJson(code);
    }

    // 注意明白为什么回调方法会执行,达成什么条件才执行
    @Recover
    public String recover(Exception e, int code) {
        // after retry will call this method , you can write to log file
        System.out.println("retry and be called");
        return "400";
    }

    @GetMapping("/codeAES")
    public String testAES() {
        return "";
    }
}
