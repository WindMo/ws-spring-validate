package ws.spring.validate.annotation;

import ws.spring.validate.validator.ColorConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author WindShadow
 * @version 2021-11-14.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Constraint(validatedBy = {ColorConstraintValidator.class}) // 表示处理的这个注解的类是哪一个，可以是多个
public @interface Color {

    String BLUE = "blue";
    String RED = "red";
    String YELLOW = "yellow";
    String GREEN = "green";

    /** 消息，一般在此预置国际化所需的code */
    String message() default "{ws.spring.validate.annotation.Color.message}";

    /** 依据class分组，该属性必须有 */
    Class<?>[] groups() default {};

    /** Payload不清楚，该属性必须有 */
    Class<? extends Payload>[] payload() default {};
}
