package org.example.validator;

import org.example.annotations.ValueEnumValid;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Str2ke
 * @date : 2023/12/6 上午1:50
 * @Desc :
 */
public class EnumValidator implements ConstraintValidator<ValueEnumValid, Object> {

    private final List<Object> values = new ArrayList<>();

    @Override
    public void initialize(ValueEnumValid constraintAnnotation) {
        Class<?> enumClazz = constraintAnnotation.value();
        Object[] enumConstants = enumClazz.getEnumConstants();
        if (null == enumConstants) {
            return;
        }

        Method method = BeanUtils.findMethod(enumClazz, constraintAnnotation.method());
//        Method method = null;
//        try {
//            method = enumClazz.getMethod(constraintAnnotation.method(), enumClazz);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }
        assert method != null;
        method.setAccessible(true);
        try {
            for (Object enumConstant : enumConstants) {
                values.add(method.invoke(enumConstant));
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return null == o || values.contains(o);
    }
}
