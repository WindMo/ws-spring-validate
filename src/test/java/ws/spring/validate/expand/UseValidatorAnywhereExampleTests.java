package ws.spring.validate.expand;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.dto.Person;
import ws.spring.validate.util.JacksonUtils;

/**
 * @author WindShadow
 * @date 2021-11-18.
 */

@Slf4j
public class UseValidatorAnywhereExampleTests extends WsSpringValidateApplicationTests {

    @Autowired
    public UseValidatorAnywhereExample example;

    private String personJson;

    @BeforeEach
    public void before() {

        personJson = JacksonUtils.toJson(new Person("123"));
    }

    /**
     * defaultValidator == localValidatorFactoryBea == validatorFactory
     * @see org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration#defaultValidator()
     */
    @Test
    public void assertBean() {

        log.info("defaultValidator == localValidatorFactoryBea == validatorFactory => {}",
                example.defaultValidator == example.localValidatorFactoryBean &&
                        example.defaultValidator == example.validatorFactory);
    }

    @Test
    public void validateBeanByValidatorFactory() {

        Assertions.assertFalse(() -> example.validateBeanByValidatorFactory(personJson));
    }

    @Test
    public void validateBeanByDefaultValidatorBean() {

        Assertions.assertFalse(() -> example.validateBeanByDefaultValidatorBean(personJson));
    }

    @Test
    public void validateBeanByLocalValidatorFactoryBean() {

        Assertions.assertFalse(() -> example.validateBeanByLocalValidatorFactoryBean(personJson));
    }

    @Test
    public void staticMethodUseValidatorFactoryOfBuild() {

        Assertions.assertFalse(() -> UseValidatorAnywhereExample.staticMethodUseValidatorFactoryOfBuild(personJson));
    }

}
