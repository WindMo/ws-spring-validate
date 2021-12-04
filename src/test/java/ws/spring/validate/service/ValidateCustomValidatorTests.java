package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.pojo.Money;

/**
 * 自定义校验器{@link org.springframework.validation.Validator}测试
 * @author WindShadow
 * @version 2021-11-16.
 */

@Slf4j
public class ValidateCustomValidatorTests extends WsSpringValidateApplicationTests {

    @Autowired
    public ValidateCustomValidator serviceBean;

    private Money money;

    @BeforeEach
    public void before() {

        money = new Money("$abc");
    }

    @Test
    public void validateSizeOfMoney() {
        Assertions.assertDoesNotThrow(() -> serviceBean.validateSizeOfMoney(money));
    }

    @Test
    public void validateMoneyOfReturn() {
        Assertions.assertDoesNotThrow(() -> serviceBean.validateMoneyOfReturn());
    }

}
