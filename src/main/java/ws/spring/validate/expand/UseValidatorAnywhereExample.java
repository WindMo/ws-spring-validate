package ws.spring.validate.expand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.SmartValidator;
import ws.spring.validate.dto.Person;
import ws.spring.validate.util.JacksonUtils;
import ws.spring.validate.util.ValidateUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 在任何地方使用Spring的校验功能完成业务校验
 * @author WindShadow
 * @date 2021-11-18.
 */

@Slf4j
@Component
public class UseValidatorAnywhereExample {

    @Autowired
    protected SmartValidator smartValidator;

    @Autowired
    protected ValidatorFactory validatorFactory;

    public boolean validateBeanBySmartValidator(String personText) {

        Person person = JacksonUtils.toObject(personText,Person.class);
        // javax包下的校验器而不是Spring的校验器
        Validator javaxValidator = validatorFactory.getValidator();
        // 校验结果
        Set<ConstraintViolation<Person>> violations = javaxValidator.validate(person);
        if (violations.isEmpty()) {
            // 为空则校验通过
            return true;
        }else {

            log.info("校验【{}】失败：{}",personText,ValidateUtils.cleanUpBindingResultByGeneric(violations));
            return false;
        }
    }


}
