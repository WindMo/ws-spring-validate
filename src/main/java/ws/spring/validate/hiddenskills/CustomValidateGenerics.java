package ws.spring.validate.hiddenskills;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.pojo.Box;

import javax.validation.constraints.NotBlank;

/**
 * @author WindShadow
 * @version 2021-12-04.
 */

@Slf4j
@Validated
@Service
public class CustomValidateGenerics {

    /**
     * 校验java类中的泛型，bean类型
     *
     * @param box
     */
    public void validateGenericsOfJavaBean(Box<@NotBlank String> box) {

        log.info("box: {}", box);
    }
}
