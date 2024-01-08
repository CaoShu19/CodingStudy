package org.example.model;

import lombok.Data;
import org.example.annotations.ValueEnumValid;
import org.example.constance.OrderTypeEnum;

/**
 * @author : Str2ke
 * @date : 2023/12/6 上午1:40
 * @Desc :
 */
@Data
public class TOrder {
    String orderId;
    String name;

    @ValueEnumValid(value = OrderTypeEnum.class, message = "not in |error")
    Integer orderType;

}
