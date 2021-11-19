package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;

import javax.validation.ConstraintViolationException;


/**
 * 校验service bean方法返回值测试
 * @author WindShadow
 * @version 2021-11-15.
 */

@Slf4j
public class ValidateServiceMethodReturnTests extends WsSpringValidateApplicationTests {

    @Autowired
    public ValidateServiceMethodReturn serviceBean;

    @Test
    public void validateBeanByValidAnnotation() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.validateBeanByValidAnnotation());
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateBeanByValidatedAnnotation() {

        Assertions.assertDoesNotThrow(() -> serviceBean.validateBeanByValidatedAnnotation());
    }

    @Test
    public void validatedBasic() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.validateBasic());
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateCollectionByValidAnnotation() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.validateCollectionByValidAnnotation());
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateCollectionByValidatedAnnotation() {

        Assertions.assertDoesNotThrow(() -> serviceBean.validateCollectionByValidatedAnnotation());
    }
}
