package ws.spring.validate.support;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.EnumSet;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

@SuppressWarnings({"rawtypes"})
public class EnumRangeRangeConstraintValidator implements ConstraintValidator<EnumRange,Object> {

    private String message;
    private EnumSet elementSet;

    @SuppressWarnings({"unchecked"})
    @Override
    public void initialize(EnumRange enumRange) {

        Class<? extends Enum> type = enumRange.type();
        this.message = enumRange.message();
        String[] elements = enumRange.elements();
        if (elements.length == 0) {
            throw new IllegalStateException("The elements in the <"+ EnumRange.class.getName() + "> annotation must contain at least one element");
        }
        elementSet = EnumSet.noneOf(type);
        for (String element : elements) {

            Enum e = Enum.valueOf(type,element);
            elementSet.add(e);
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if (!elementSet.contains(value)) {

            // 禁用默认的消息模板
            context.disableDefaultConstraintViolation();
            // 设置自己的消息模板
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return true;
    }
}
