package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.annotation.NormalText;

/**
 * 组合注解使用示例
 * @author WindShadow
 * @version 2021-12-17.
 */

@Slf4j
@Validated
@Service
public class CombinationAnnotationService {

    public void validateNormalText(@NormalText String text) {
        log.info("text: {}",text);
    }

    public void validateNormalTextCustomOption(@NormalText(min = 2) String text) {
        log.info("text: {}",text);
    }
}
