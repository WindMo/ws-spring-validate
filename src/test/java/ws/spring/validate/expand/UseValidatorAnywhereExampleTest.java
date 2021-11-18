package ws.spring.validate.expand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.dto.Person;
import ws.spring.validate.util.JacksonUtils;

/**
 * @author WindShadow
 * @date 2021-11-18.
 */

public class UseValidatorAnywhereExampleTest extends WsSpringValidateApplicationTests {

    @Autowired
    public UseValidatorAnywhereExample example;

    @Test
    public void validateBeanBySmartValidator() {

        String jsonText = JacksonUtils.toJson(new Person("123"));
        Assertions.assertFalse(() -> example.validateBeanBySmartValidator(jsonText));
    }

}
