package ws.spring.validate.support;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.enums.Direction;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.lang.annotation.ElementType;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

@Slf4j
public class ValidateEnumRangeSupportServiceTests extends WsSpringValidateApplicationTests {

    @Autowired
    private ValidateEnumRangeSupportService validateSupportService;

    @Test
    public void validateEnumRange() {

        Assertions.assertDoesNotThrow(() -> validateSupportService.validateEnumRange(Direction.UP));
        Assertions.assertDoesNotThrow(() -> validateSupportService.validateEnumRange(Direction.DOWN));
        ConstraintViolationException e1 = Assertions.assertThrows(ConstraintViolationException.class, () -> validateSupportService.validateEnumRange(Direction.LEFT));
        log.info("ConstraintViolationException: {}",e1.getMessage());
        ConstraintViolationException e2 = Assertions.assertThrows(ConstraintViolationException.class, () -> validateSupportService.validateEnumRange(Direction.RIGHT));
        log.info("ConstraintViolationException: {}",e2.getMessage());
        ValidationException e3 = Assertions.assertThrows(ValidationException.class, () -> validateSupportService.validateEnumRangeErrorEnumType(ElementType.METHOD));
        log.info("ValidationException: {}",e3.getMessage());
    }

    @Test
    public void validateEnumRangeErrorEnumName() {

        ValidationException e = Assertions.assertThrows(ValidationException.class, () -> validateSupportService.validateEnumRangeErrorEnumName(Direction.LEFT));
        log.info("ValidationException: {}",e.getMessage());
    }

    @Test
    public void validateEnumRangeErrorWithoutRange() {

        ValidationException e = Assertions.assertThrows(ValidationException.class, () -> validateSupportService.validateEnumRangeErrorWithoutRange(Direction.LEFT));
        log.info("ValidationException: {}",e.getMessage());
    }
}
