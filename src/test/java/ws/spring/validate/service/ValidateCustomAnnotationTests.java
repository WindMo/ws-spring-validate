package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.pojo.Car;

import javax.validation.ConstraintViolationException;

/**
 * @author WindShadow
 * @version 2021-11-16.
 */

@Slf4j
public class ValidateCustomAnnotationTests extends WsSpringValidateApplicationTests {

    @Autowired
    public ValidateCustomAnnotation serviceBean;

    private Car car;

    @BeforeEach
    public void before() {

        car = new Car("abc");
    }

    @Test
    public void validateColorOfCar() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.validateColorOfCar(car));
        log.info("ConstraintViolationException: {}",e.getMessage());
    }
}
