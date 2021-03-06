package ws.spring.validate.hiddenskills;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.hiddenskills.service.ChangeConstraintWhenExtends;

import javax.validation.ConstraintDeclarationException;

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
    public void doSomethingParam() {

        ConstraintDeclarationException e = Assertions.assertThrows(ConstraintDeclarationException.class, () -> changeConstraintWhenExtends.doSomethingParam(10));
        log.info("ConstraintDeclarationException: {}",e.getMessage());
    }

    /**
     * 失败，抛出约束声明异常
     */
    @Test
    public void doSomethingReturn() {

        ConstraintDeclarationException e = Assertions.assertThrows(ConstraintDeclarationException.class, () -> changeConstraintWhenExtends.doSomethingReturn());
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    /**
     * 失败，抛出约束声明异常
     */
    @Test
    public void returnIntTest() {

        ConstraintDeclarationException e = Assertions.assertThrows(ConstraintDeclarationException.class, () -> changeConstraintWhenExtends.returnInt());
        log.info("ConstraintViolationException: {}",e.getMessage());
    }
}
