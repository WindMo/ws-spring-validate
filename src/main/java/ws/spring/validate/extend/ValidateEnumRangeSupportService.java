package ws.spring.validate.extend;

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
public class ValidateEnumRangeSupportService {

    public void validateEnumRange(@EnumRange(enumType = Direction.class, enums = {"UP", "DOWN"}) Direction direction) {

        log.info("direction: {}", direction);
    }

    public void validateEnumRangeErrorWithoutRange(@EnumRange(enumType = Direction.class, enums = {}) Direction direction) {

        log.info("direction: {}", direction);
    }

    public void validateEnumRangeErrorEnumName(@EnumRange(enumType = Direction.class, enums = {"abc"}) Direction direction) {

        log.info("direction: {}", direction);
    }

    public void validateEnumRangeErrorEnumType(@EnumRange(enumType = Direction.class, enums = {"DOWN"}) ElementType elementType) {

        log.info("elementType: {}", elementType);
    }


}
