package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.pojo.Money;

import javax.validation.Valid;

/**
 * 自定义校验器{@link org.springframework.validation.Validator}测试service
 *
 * @author WindShadow
 * @version 2021-11-16.
 * @see ws.spring.validate.validator.MoneyValidator
 */

@Slf4j
@Validated
@Service
public class ValidateCustomValidator {

    /**
     * {@link Money#getSize()} ()}的属性校验测试；校验失败
     * 因为{@link ws.spring.validate.validator.MoneyValidator}即{@link org.springframework.validation.Validator}只能在web层的数据绑定时使用
     * 此处校验的是{@link Money}内的约束，而其属性无约束
     *
     * @param money
     * @deprecated 无效
     */
    @Deprecated
    public void validateSizeOfMoney(@Valid Money money) {

        log.info("money: {}", money);
    }


    /**
     * 理由同{@link #validateSizeOfMoney(Money)}
     *
     * @deprecated 无效
     */
    @Valid
    @Deprecated
    public Money validateMoneyOfReturn() {

        Money money = new Money("$abc");
        log.info("money: {}", money);
        return money;
    }
}
