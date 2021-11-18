package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;

/**
 * @author WindShadow
 * @version 2021-11-17.
 */

@Slf4j
public class GroupValidateOfServiceTest extends WsSpringValidateApplicationTests {

    @Autowired
    public GroupValidateOfService serviceBean;

    @Test
    public void groupValidateBasicQuery() {

        Exception e = Assertions.assertThrows(Exception.class, () -> serviceBean.groupValidateBasicQuery("  "));
        log.info("Exception: {}",e.getMessage());
    }

    @Test
    public void groupValidateBasicDelete() {

       Assertions.assertDoesNotThrow(() -> serviceBean.groupValidateBasicDelete("  "));
    }
}
