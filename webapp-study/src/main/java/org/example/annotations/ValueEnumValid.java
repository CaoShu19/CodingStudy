package org.example.annotations;


import org.example.validator.EnumValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = EnumValidator.class)
public @interface ValueEnumValid {
    Class<?> value();

    String method() default "getCode";
    String message() default "value is not right";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
