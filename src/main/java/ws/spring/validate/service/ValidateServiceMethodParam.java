package ws.spring.validate.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.pojo.Person;
import ws.spring.validate.pojo.User;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 校验service bean方法参数测试service
 * Spring Bean中支持使用{@link Validated}修饰类，使用{@link Valid}或约束注解（如{@link NotBlank}） 修饰【方法参数】，其方法在被调用前，校验【方法参数】
 * 而使用{@link Valid} 修饰类，使用{@link Validated}修饰方法参数则无效
 *
 * @author WindShadow
 * @version 2021-11-15.
 */

@Slf4j
@Validated
@Service
public class ValidateServiceMethodParam {

    //    @Autowired // 不能通过依赖注入自己！！！目前未了解
    @Setter
    private ValidateServiceMethodParam serviceMethodParam;

    /**
     * 校验bean；使用{@link Valid}修饰形参
     *
     * @param person
     */
    public void validateBeanByValidAnnotation(@Valid Person person) {
        log.info("person: {}", person);
    }

    /**
     * 校验bean；使用{@link Validated}修饰形参反而无用
     *
     * @param user
     * @deprecated 无效
     */
    @Deprecated
    public void validateBeanByValidatedAnnotation(@Validated User user) {
        log.info("user: {}", user);
    }

    /**
     * 校验基本类型
     *
     * @param str
     */
    public void validateBasic(@NotBlank String str) {
        log.info("str: {}", str);
    }

    /**
     * 校验bean集合；使用{@link Valid}修饰形参
     *
     * @param personList
     */
    public void validateCollectionByValidAnnotation(@Valid List<Person> personList) {
        log.info("personList: {}", personList);
    }

    /**
     * 校验bean集合；使用{@link Validated}修饰形参反而无用
     *
     * @param userList
     * @deprecated 无效
     */
    @Deprecated
    public void validateCollectionByValidatedAnnotation(@Validated List<User> userList) {
        log.info("userList: {}", userList);
    }

    /**
     * 自身this调用，并不会触发校验，与Spring事务类似
     *
     * @param person
     * @deprecated 不触发校验
     */
    @Deprecated
    public void callThisMethod(Person person) {

        this.validateBeanByValidAnnotation(person);
    }

    /**
     * 手动调用{@link #setServiceMethodParam(ValidateServiceMethodParam)}方法设置“自己”（被代理过）后，调用会触发校验
     *
     * @param person
     */
    public void callInjectSelfMethod(Person person) {

        serviceMethodParam.validateBeanByValidAnnotation(person);
    }
}
