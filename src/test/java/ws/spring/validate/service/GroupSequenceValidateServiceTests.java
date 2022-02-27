package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.pojo.House;

import javax.validation.ConstraintViolationException;

/**
 * @author WindShadow
 * @version 2022-02-27.
 */

@Slf4j
public class GroupSequenceValidateServiceTests extends WsSpringValidateApplicationTests {

    @Autowired
    public GroupSequenceValidateService serviceBean;

    @Test
    public void groupValidateGroupSequenceTest() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.groupValidateGroupSequence(new House(100, "email")));
        log.info("ConstraintViolationException: {}", e.getMessage());
    }
}
