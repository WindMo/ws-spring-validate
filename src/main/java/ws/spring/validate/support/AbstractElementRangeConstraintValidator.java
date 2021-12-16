package ws.spring.validate.support;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

public abstract class AbstractElementRangeConstraintValidator<A extends Annotation,T> implements ConstraintValidator<A,T> {

    private Set<T> elements;

    @Override
    public void initialize(A constraintAnnotation) {

        elements = getElements(constraintAnnotation);
        if (elements.isEmpty()) {
            throw new IllegalStateException("The elements in the <"+ constraintAnnotation.getClass().getName() + "> annotation must contain at least one element");
        }
    }

    @Override
    public boolean isValid(T value, ConstraintValidatorContext context) {

        if (!elements.contains(value)) {

            invalid(value,context);
            return false;
        }
        return true;
    }

    /**
     * 从注解中获取元素Set
     * @param constraintAnnotation
     * @return {@link Set#isEmpty()}必须为false
     */
    protected abstract Set<T> getElements(A constraintAnnotation);

    /**
     * 校验不通过时调用
     * @param value
     * @param context
     */
    protected abstract void invalid(T value, ConstraintValidatorContext context);
}
