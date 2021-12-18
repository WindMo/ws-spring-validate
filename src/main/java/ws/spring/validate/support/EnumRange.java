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
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Constraint(validatedBy = {EnumRangeRangeConstraintValidator.class})
public @interface EnumRange {

    /** 枚举类型 */
    Class<? extends Enum<?>> enumType();

    /**
     * 枚举名称数组，其中的字符串必须是可以通过{@link Enum#valueOf(Class, String)}方法可以得到枚举实例的枚举名称
     * @return enums
     */
    String[] enums();

    String message() default "{ws.spring.validate.support.EnumRange.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
