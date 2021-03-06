package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.pojo.Car;

import javax.validation.Valid;

/**
 * 自定义校验注解测试service
 *
 * @author WindShadow
 * @version 2021-11-16.
 * @see Car
 * @see ws.spring.validate.annotation.Color
 */

@Slf4j
@Validated
@Service
public class ValidateCustomAnnotation {

    /**
     * {@link Car#getColor()}的属性校验测试
     *
     * @param car
     */
    public void validateColorOfCar(@Valid Car car) {

        log.info("car: {}", car);
    }
}
