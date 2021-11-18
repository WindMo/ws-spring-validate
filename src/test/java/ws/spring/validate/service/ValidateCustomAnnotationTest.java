package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.dto.Car;

/**
 * @author WindShadow
 * @version 2021-11-16.
 */

@Slf4j
public class ValidateCustomAnnotationTest extends WsSpringValidateApplicationTests {

    @Autowired
    public ValidateCustomAnnotation serviceBean;

    private Car car;

    @BeforeEach
    public void before() {

        car = new Car("abc");
    }

    @Test
    public void validateColorOfCar() {

        Exception e = Assertions.assertThrows(Exception.class, () -> serviceBean.validateColorOfCar(car));
        log.info("Exception: {}",e.getMessage());
    }
}
