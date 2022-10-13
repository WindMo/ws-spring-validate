package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.pojo.Pot;

import javax.validation.Valid;

/**
 * @author WindShadow
 * @version 2022-10-14.
 */

@Slf4j
@Validated
@Service
public class GroupSequenceProviderService {

    public void groupValidateForSequenceProvider(@Valid Pot pot) {

        log.info("pot: {}", pot);
    }
}
