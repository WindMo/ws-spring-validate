package ws.spring.validate.support;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Constraint(validatedBy = {EnumRangeRangeConstraintValidator.class})
public @interface EnumRange {

    Class<? extends Enum<?>> type();

    String[] elements();

    /** 消息，一般在此预置国际化所需的code */
    String message() default "";// 简化代码直接空字符

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
