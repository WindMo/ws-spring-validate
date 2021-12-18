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

    Class<? extends Enum<?>> type();

    String[] elements();

    String message() default "{ws.spring.validate.support.EnumRange.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
