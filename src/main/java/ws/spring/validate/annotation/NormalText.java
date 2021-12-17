package ws.spring.validate.annotation;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

/**
 * @author WindShadow
 * @version 2021-12-17.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Constraint(validatedBy = {})
@Size
@Pattern(regexp = "[a-zA-Z]*")
//@ReportAsSingleViolation
public @interface NormalText {

    /** 覆盖{@link Size#min()} */
    @OverridesAttribute(constraint = Size.class, name = "min") int min() default 0;
    /** 覆盖{@link Size#max()} */
    @OverridesAttribute(constraint = Size.class, name = "max") int max() default 5;

    String message() default "{ws.spring.validate.annotation.NormalText.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}