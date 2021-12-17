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
    public void validateLetterText() {

        Assertions.assertDoesNotThrow(() -> combinationAnnotationService.validateLetterText("abc"));
        Assertions.assertDoesNotThrow(() -> combinationAnnotationService.validateLetterText(""));
        ConstraintViolationException e1 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateLetterText(" "));
        log.info("ConstraintViolationException: {}",e1.getMessage());
        ConstraintViolationException e2 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateLetterText("123"));
        log.info("ConstraintViolationException: {}",e2.getMessage());
        ConstraintViolationException e3 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateLetterText("abcdef"));
        log.info("ConstraintViolationException: {}",e3.getMessage());
        ConstraintViolationException e4 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateLetterText("123456"));
        log.info("ConstraintViolationException: {}",e4.getMessage());
    }

    @Test
    public void validateLetterTextCustomOption() {

        Assertions.assertDoesNotThrow(() -> combinationAnnotationService.validateLetterTextCustomOption("abc"));
        ConstraintViolationException e0 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateLetterTextCustomOption("a"));
        log.info("ConstraintViolationException: {}",e0.getMessage());
        ConstraintViolationException e00 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateLetterTextCustomOption(""));
        log.info("ConstraintViolationException: {}",e00.getMessage());
        ConstraintViolationException e1 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateLetterTextCustomOption(" "));
        log.info("ConstraintViolationException: {}",e1.getMessage());
        ConstraintViolationException e2 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateLetterTextCustomOption("123"));
        log.info("ConstraintViolationException: {}",e2.getMessage());
        ConstraintViolationException e3 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateLetterTextCustomOption("abcdef"));
        log.info("ConstraintViolationException: {}",e3.getMessage());
        ConstraintViolationException e4 = Assertions.assertThrows(ConstraintViolationException.class, () -> combinationAnnotationService.validateLetterTextCustomOption("123456"));
        log.info("ConstraintViolationException: {}",e4.getMessage());
    }
}
