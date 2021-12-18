package ws.spring.validate.support;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import ws.spring.validate.WsSpringValidateApplicationTests;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Locale;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

@Slf4j
public class ValidateStringRangeSupportServiceTests extends WsSpringValidateApplicationTests {

    @Autowired
    private ValidateStringRangeSupportService stringRangeSupportService;

    @Test
    public void validateStringRange() {

        LocaleContextHolder.setLocale(Locale.CHINA);

        Assertions.assertDoesNotThrow(() -> stringRangeSupportService.validateStringRange("aaa"));
        Assertions.assertDoesNotThrow(() -> stringRangeSupportService.validateStringRange("bbb"));
        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> stringRangeSupportService.validateStringRange("ccc"));
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateStringRangeErrorWithoutRange() {

        ValidationException e = Assertions.assertThrows(ValidationException.class, () -> stringRangeSupportService.validateStringRangeErrorWithoutRange("123"));
        log.info("ValidationException: {}",e.getMessage());
    }
}
