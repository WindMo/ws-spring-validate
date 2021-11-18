package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.dto.Person;
import ws.spring.validate.dto.User;

import java.util.Collections;

/**
 * 校验service bean方法参数测试
 * @author WindShadow
 * @version 2021-11-15.
 */

@Slf4j
public class ValidateServiceMethodParamTest extends WsSpringValidateApplicationTests {

    @Autowired
    public ValidateServiceMethodParam serviceBean;

    private Person person;
    private User user;
    private String blankString;

    @BeforeEach
    public void before() {

        person = new Person("123");
        user = new User("123");
        blankString = "   ";
    }

    @Test
    public void validateBeanByValidAnnotation() {

        Exception e = Assertions.assertThrows(Exception.class, () -> serviceBean.validateBeanByValidAnnotation(person));
        log.info("Exception: {}",e.getMessage());
    }

    @Test
    public void validateBeanByValidatedAnnotation() {

        Assertions.assertDoesNotThrow(() -> serviceBean.validateBeanByValidatedAnnotation(user));
    }

    @Test
    public void validatedBasic() {

        Exception e = Assertions.assertThrows(Exception.class, () -> serviceBean.validateBasic(blankString));
        log.info("Exception: {}",e.getMessage());
    }

    @Test
    public void validateCollectionByValidAnnotation() {

        Exception e = Assertions.assertThrows(Exception.class, () -> serviceBean.validateCollectionByValidAnnotation(Collections.singletonList(person)));
        log.info("Exception: {}",e.getMessage());
    }

    @Test
    public void validateCollectionByValidatedAnnotation() {

       Assertions.assertDoesNotThrow(() -> serviceBean.validateCollectionByValidatedAnnotation(Collections.singletonList(user)));
    }
}
