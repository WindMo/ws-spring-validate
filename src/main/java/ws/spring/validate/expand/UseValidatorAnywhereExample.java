package ws.spring.validate.expand;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.SmartValidator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import ws.spring.validate.pojo.Person;
import ws.spring.validate.util.JacksonUtils;
import ws.spring.validate.util.ValidateUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
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

    @Qualifier("defaultValidator")
    @Autowired
    protected Validator defaultValidator;

    @Autowired
    protected LocalValidatorFactoryBean localValidatorFactoryBean;

    public boolean validateBeanByValidatorFactory(String personText) {

        // javax包下的校验器而不是Spring的校验器
        Validator javaxValidator = validatorFactory.getValidator();
        return doValidate(personText,javaxValidator);
    }

    public boolean validateBeanByDefaultValidatorBean(String personText) {

        return doValidate(personText,defaultValidator);
    }

    public boolean validateBeanByLocalValidatorFactoryBean(String personText) {

        return doValidate(personText,localValidatorFactoryBean);
    }

    private static boolean doValidate(String personText, Validator javaxValidator) {

        Person person = JacksonUtils.toObject(personText,Person.class);
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

    public static boolean staticMethodUseValidatorFactoryOfBuild(String personText) {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return doValidate(personText,validator);
    }
}
