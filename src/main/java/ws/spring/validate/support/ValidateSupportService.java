package ws.spring.validate.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.enums.Direction;

import java.lang.annotation.ElementType;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

@Slf4j
@Validated
@Service
public class ValidateSupportService {

    public void validateEnumRange(@EnumRange(type = Direction.class, elements = {"UP","DOWN"}) Direction direction) {

        log.info("direction: {}",direction);
    }

    public void validateEnumRangeErrorWithoutEnum(@EnumRange(type = Direction.class, elements = {}) Direction direction) {

        log.info("direction: {}",direction);
    }

    public void validateEnumRangeErrorEnumName(@EnumRange(type = Direction.class, elements = {"abc"}) Direction direction) {

        log.info("direction: {}",direction);
    }

    public void validateEnumRangeErrorEnumType(@EnumRange(type = Direction.class, elements = {"DOWN"}) ElementType elementType) {

        log.info("elementType: {}",elementType);
    }
}
