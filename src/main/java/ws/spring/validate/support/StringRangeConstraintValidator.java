package ws.spring.validate.support;

import javax.validation.ConstraintValidatorContext;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

public class StringRangeConstraintValidator extends AbstractElementRangeConstraintValidator<StringRange,String> {

    private String message;

    @Override
    protected Set<String> getElements(StringRange stringRange) {

        this.message = stringRange.message();
       return Stream.of(stringRange.value()).collect(Collectors.toSet());
    }

    @Override
    protected void invalid(String value, ConstraintValidatorContext context) {

        // 禁用默认的消息模板
        context.disableDefaultConstraintViolation();
        // 设置自己的消息模板
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
