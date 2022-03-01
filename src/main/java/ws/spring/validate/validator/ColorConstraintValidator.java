package ws.spring.validate.validator;

import ws.spring.validate.annotation.Color;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 自定义注解的约束校验器
 * Color约束校验器
 *
 * @author WindShadow
 * @version 2021-11-14.
 */

public class ColorConstraintValidator implements ConstraintValidator<Color, String> {

    private static final Set<String> COLORS = Stream.of(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW).collect(Collectors.toSet());
    private String message;

    @Override
    public void initialize(Color constraintAnnotation) {

        String msg = constraintAnnotation.message();
        this.message = msg.isEmpty() ? "颜色编码有误，枚举如下：" + COLORS : msg;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (!COLORS.contains(value)) {

            // 禁用默认的消息模板
            context.disableDefaultConstraintViolation();
            // 设置自己的消息模板
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
            return false;
        }
        return true;
    }
}
