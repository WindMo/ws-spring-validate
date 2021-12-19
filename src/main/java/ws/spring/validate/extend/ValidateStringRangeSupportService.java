package ws.spring.validate.extend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

@Slf4j
@Validated
@Service
public class ValidateStringRangeSupportService {
    
    public void validateStringRange(@StringRange({"aaa","bbb"}) String str) {

        log.info("str: {}",str);
    }

    public void validateStringRangeErrorWithoutRange(@StringRange({}) String str) {

        log.info("str: {}",str);
    }
}
