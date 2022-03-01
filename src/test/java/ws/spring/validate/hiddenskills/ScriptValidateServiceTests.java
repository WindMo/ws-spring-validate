package ws.spring.validate.hiddenskills;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.hiddenskills.service.ScriptValidateService;
import ws.spring.validate.pojo.Phone;

import javax.validation.ConstraintViolationException;

/**
 * @author WindShadow
 * @version 2022-03-01.
 */

@Slf4j
public class ScriptValidateServiceTests extends WsSpringValidateApplicationTests {

    @Autowired
    private ScriptValidateService scriptValidateService;

    @Test
    public void validateScriptAssertBeanTest() {

        Assertions.assertDoesNotThrow(() -> scriptValidateService.validateScriptAssertBean(new Phone(null,null)));

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class,
                () -> scriptValidateService.validateScriptAssertBean(new Phone(1001,null)));
        log.info("ConstraintViolationException: {}",e.getMessage());
    }
}
