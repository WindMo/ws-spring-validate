package ws.spring.validate.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ws.spring.validate.pojo.Money;

/**
 * 自定义校验器
 * java类{@link Money}的校验器
 * 可使用{@link Component}加入IOC，搭配{@link ws.spring.validate.config.CustomWebBindingInitializer}使用比较方便
 *
 * @author WindShadow
 * @version 2021-11-14.
 */

@Component
public class MoneyValidator implements Validator {

    private static final String DOLLAR = "$";
    private static final String RMB = "￥";

    @Override
    public boolean supports(Class<?> clazz) {
        return Money.class.isAssignableFrom(clazz);
    }

    /**
     * 对目标进行校验；搭配{@link ValidationUtils}对target进行常见的断言为最佳操作
     *
     * @param target 被校验对象
     * @param errors 封装校验结果的错误对象
     */
    @Override
    public void validate(Object target, Errors errors) {

        final String mainCode = Money.class.getTypeName();
        ValidationUtils.rejectIfEmpty(errors, "size", mainCode + ".size.null", "金钱数量不能为空");
        Money money = (Money) target;
        String size = money.getSize();
        if (size.startsWith(DOLLAR) || size.startsWith(RMB)) {

            try {
                Long.valueOf(size.substring(1));
            } catch (NumberFormatException e) {

                errors.rejectValue("size", mainCode + ".size.format-error", "金钱数量数字部分格式有误");
            }
        } else {
            errors.rejectValue("size", mainCode + ".size.prefix", new Object[]{DOLLAR, RMB}, "金钱数量必须以" + DOLLAR + "或" + RMB + "开头");
        }
    }
}
