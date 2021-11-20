package ws.spring.validate.hiddenskills;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.hiddenskills.service.ChangeConstraintWhenExtends;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;

/**
 * @author WindShadow
 * @date 2021-11-20.
 */
@Slf4j
public class ChangeConstraintWhenExtendsTests extends WsSpringValidateApplicationTests {

    @Autowired
    public ChangeConstraintWhenExtends changeConstraintWhenExtends;

    /**
     * 失败，抛出约束声明异常
     */
    @Test
    @SneakyThrows(ConstraintDeclarationException.class)
    public void doSomethingParam() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> changeConstraintWhenExtends.doSomethingParam(10));
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    /**
     * 失败，抛出约束声明异常
     */
    @Test
    @SneakyThrows(ConstraintDeclarationException.class)
    public void doSomethingReturn() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> changeConstraintWhenExtends.doSomethingReturn());
        log.info("ConstraintViolationException: {}",e.getMessage());
    }
}
