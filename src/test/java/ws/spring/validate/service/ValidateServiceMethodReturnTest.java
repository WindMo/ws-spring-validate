package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;


/**
 * 校验service bean方法返回值测试
 * @author WindShadow
 * @version 2021-11-15.
 */

@Slf4j
public class ValidateServiceMethodReturnTest extends WsSpringValidateApplicationTests {

    @Autowired
    public ValidateServiceMethodReturn serviceBean;
    
    @Test
    public void validateBeanByValidAnnotation() {

        Exception e = Assertions.assertThrows(Exception.class, () -> serviceBean.validateBeanByValidAnnotation());
        log.info("Exception: {}",e.getMessage());
    }

    @Test
    public void validateBeanByValidatedAnnotation() {

        Assertions.assertDoesNotThrow(() -> serviceBean.validateBeanByValidatedAnnotation());
    }

    @Test
    public void validatedBasic() {

        Exception e = Assertions.assertThrows(Exception.class, () -> serviceBean.validateBasic());
        log.info("Exception: {}",e.getMessage());
    }

    @Test
    public void validateCollectionByValidAnnotation() {

        Exception e = Assertions.assertThrows(Exception.class, () -> serviceBean.validateCollectionByValidAnnotation());
        log.info("Exception: {}",e.getMessage());
    }

    @Test
    public void validateCollectionByValidatedAnnotation() {

       Assertions.assertDoesNotThrow(() -> serviceBean.validateCollectionByValidatedAnnotation());
    }
}
