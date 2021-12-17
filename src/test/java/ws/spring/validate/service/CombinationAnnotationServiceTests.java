package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;

import javax.validation.ConstraintViolationException;

/**
 * @author WindShadow
 * @version 2021-12-17.
 */

@Slf4j
public class CombinationAnnotationServiceTests extends WsSpringValidateApplicationTests {

    @Autowired
    private CombinationAnnotationService combinationAnnotationService;

    @Test
    public void validateNormalText() {

        Assertions.assertDoesNotThrow(() -> combinationAnnotationService.validateNormalText("abc"));
        Assertions.assertDoesNotThrow(() -> combinationAnnotationService.validateNormalText(""));
        ConstraintViolationException e1 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateNormalText(" "));
        log.info("ConstraintViolationException: {}",e1.getMessage());
        ConstraintViolationException e2 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateNormalText("123"));
        log.info("ConstraintViolationException: {}",e2.getMessage());
        ConstraintViolationException e3 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateNormalText("abcdef"));
        log.info("ConstraintViolationException: {}",e3.getMessage());
        ConstraintViolationException e4 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateNormalText("123456"));
        log.info("ConstraintViolationException: {}",e4.getMessage());
    }

    @Test
    public void validateNormalTextCustomOption() {

        Assertions.assertDoesNotThrow(() -> combinationAnnotationService.validateNormalTextCustomOption("abc"));
        ConstraintViolationException e0 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateNormalTextCustomOption("a"));
        log.info("ConstraintViolationException: {}",e0.getMessage());
        ConstraintViolationException e00 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateNormalTextCustomOption(""));
        log.info("ConstraintViolationException: {}",e00.getMessage());
        ConstraintViolationException e1 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateNormalTextCustomOption(" "));
        log.info("ConstraintViolationException: {}",e1.getMessage());
        ConstraintViolationException e2 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateNormalTextCustomOption("123"));
        log.info("ConstraintViolationException: {}",e2.getMessage());
        ConstraintViolationException e3 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateNormalTextCustomOption("abcdef"));
        log.info("ConstraintViolationException: {}",e3.getMessage());
        ConstraintViolationException e4 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateNormalTextCustomOption("123456"));
        log.info("ConstraintViolationException: {}",e4.getMessage());
    }
}
