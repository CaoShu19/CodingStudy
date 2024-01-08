package org.example.constance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : Str2ke
 * @date : 2023/12/6 上午1:42
 * @Desc :
 */

@AllArgsConstructor
@Getter
public enum OrderTypeEnum {
    SHOP_ORDER(1),
    GAME_ORDER(2),
    ;

    private final int code;
}
