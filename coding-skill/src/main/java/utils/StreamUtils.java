package utils;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author : Str2ke
 * @date : 2024/1/29 上午12:22
 * @Desc : 此工具用于流访问容器内对象时获得其索引下标
 * 通过内部类维护索引,注意并行流无法使用
 *
 */
public class StreamUtils {

    public static <T> Consumer<T> consumerWithIndex(BiConsumer<Integer, T> consumer) {
        class Obj {
            int i;
        }
        Obj obj = new Obj();
        return t-> consumer.accept(obj.i ++ , t);
    }

    public static <U, R> Function<U, R> functionWithIndex(BiFunction<Integer, U, R> function) {
        class Obj {
            int i;
        }
        Obj obj = new Obj();
        return u -> function.apply(obj.i ++ , u);
    }
}
