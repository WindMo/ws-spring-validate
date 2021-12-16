package ws.spring.validate.support;

import javax.validation.ConstraintValidatorContext;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

@SuppressWarnings({"rawtypes"})
public class EnumRangeRangeConstraintValidator extends AbstractElementRangeConstraintValidator<EnumRange,Object> {

    private String message;

    @SuppressWarnings({"unchecked"})
    @Override
    protected Set<Object> getElements(EnumRange enumRange) {

        Class<? extends Enum> type = enumRange.type();
        this.message = enumRange.message();
        String[] elements = enumRange.elements();
        EnumSet enumSet = EnumSet.noneOf(type);
        for (String element : elements) {

            Enum e = Enum.valueOf(type,element);
            enumSet.add(e);
        }
        return enumSet;
    }

    @Override
    protected void invalid(Object value, ConstraintValidatorContext context) {

        // 禁用默认的消息模板
        context.disableDefaultConstraintViolation();
        // 设置自己的消息模板
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
