package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.pojo.Company;
import ws.spring.validate.pojo.Pot;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * @author WindShadow
 * @version 2021-11-17.
 */

@Slf4j
public class GroupValidateOfServiceTests extends WsSpringValidateApplicationTests {

    @Autowired
    public GroupValidateOfService serviceBean;

    @Autowired
    public GroupSequenceProviderService providerService;

    @Autowired
    private Validator validator;

    @Test
    public void groupValidateBasicQuery() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.groupValidateBasicQuery("  "));
        log.info("ConstraintViolationException: {}", e.getMessage());
    }

    @Test
    public void groupValidateBasicDelete() {

        Assertions.assertDoesNotThrow(() -> serviceBean.groupValidateBasicDelete("  "));
    }

    @Test
    public void groupValidateConvertGroupTest() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.groupValidateConvertGroup(new Company(null, "email")));
        log.info("ConstraintViolationException: {}", e.getMessage());
    }

    @Test
    public void groupValidateSequenceProviderTest() {

        ConstraintViolationException e;
        e = Assertions.assertThrows(ConstraintViolationException.class,
                () -> providerService.groupValidateForSequenceProvider(new Pot(0, "123456", null, 1)));
        log.info("ConstraintViolationException: {}", e.getMessage());

        e = Assertions.assertThrows(ConstraintViolationException.class,
                () -> providerService.groupValidateForSequenceProvider(new Pot(0, "123456", "blue", 1)));
        log.info("ConstraintViolationException: {}", e.getMessage());

        e = Assertions.assertThrows(ConstraintViolationException.class,
                () -> providerService.groupValidateForSequenceProvider(new Pot(2, "123456", null, 1)));
        log.info("ConstraintViolationException: {}", e.getMessage());

        e = Assertions.assertThrows(ConstraintViolationException.class,
                () -> providerService.groupValidateForSequenceProvider(new Pot(2, "123456", "blue", 1)));
        log.info("ConstraintViolationException: {}", e.getMessage());
    }
}
