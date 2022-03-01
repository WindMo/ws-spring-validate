package ws.spring.validate.hiddenskills.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.pojo.Phone;

import javax.validation.Valid;

/**
 * @author WindShadow
 * @version 2022-03-01.
 */

@Slf4j
@Validated
@Service
public class ScriptValidateService {

    public void validateScriptAssertBean(@Valid Phone phone) {

        log.info("phone: {}", phone);
    }
}
