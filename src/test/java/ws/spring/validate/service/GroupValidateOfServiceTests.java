package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.pojo.Company;

import javax.validation.ConstraintViolationException;

/**
 * @author WindShadow
 * @version 2021-11-17.
 */

@Slf4j
public class GroupValidateOfServiceTests extends WsSpringValidateApplicationTests {

    @Autowired
    public GroupValidateOfService serviceBean;

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
}
