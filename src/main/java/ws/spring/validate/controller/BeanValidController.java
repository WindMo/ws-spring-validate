package ws.spring.validate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.spring.validate.pojo.Money;
import ws.spring.validate.pojo.People;
import ws.spring.validate.pojo.Person;
import ws.spring.validate.validator.MoneyValidator;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

/**
 * {@link Valid}在Controller控制器中校验【bean类型】；关键：方法参数上加{@link Valid}注解
 * Spring Bean本身支持【使用{@link org.springframework.validation.annotation.Validated}修饰类，使用{@link javax.validation.Valid}修饰方法参数】来进行参数校验，例子见{@link ws.spring.validate.service.ValidateServiceMethodParam}
 * Spring对Controller进行了特殊支持：校验【bean类型】的方法参数时，Controller可直接使用{@link Valid}校验bean类型的方法参数，不过Controller中更推荐使用{@link org.springframework.validation.annotation.Validated}，如{@link BeanValidatedController}
 * 不过校验【简单类型】的方法参数时，需要使用原来的套路，如{@link BasicTypeValidatedController}
 *
 * @author WindShadow
 * @version 2021-11-14.
 * @see ws.spring.validate.service.ValidateServiceMethodParam
 * @see BeanValidatedController
 * @see BasicTypeValidatedController
 */

@Slf4j
@RestController
@RequestMapping("/valid/bean")
public class BeanValidController {

    /**
     * {@link Valid}注解修饰方法参数，bean类型
     *
     * @param person 实际校验{@link Person}内部被约束注解修饰的属性
     * @return
     */
    @PostMapping("/method-param-bean")
    public String validMethodParamBean(@Valid @RequestBody Person person) {

        log.info("person: {}", person);
        return String.valueOf(person);
    }

    /**
     * {@link Valid}注解修饰方法参数，bean类型集合，无效
     *
     * @param personList
     * @return
     * @deprecated 无效
     */
    @PostMapping("/method-param-bean-collection")
    @Deprecated
    public String validatedMethodParamBeaCollection(@Valid @RequestBody List<Person> personList) {

        log.info("personList: {}", personList);
        return String.valueOf(personList);
    }

    /**
     * {@link Valid}注解修饰方法参数，非bean类型；无效
     *
     * @param email
     * @return
     * @deprecated 无效
     */
    @PostMapping("/method-param-basic")
    @Deprecated
    public String validMethodParamBasic(@Valid @Email String email) {

        log.info("email: {}", email);
        return String.valueOf(email);
    }

    /**
     * {@link Valid}注解修饰方法参数，非bean类型集合；无效
     * 实际结果会抛异常，因为{@link Email}没有对应的验证集合的校验器
     *
     * @param emailList 此参数加不加{@link Valid}注解都是无效
     * @return
     * @deprecated 无效
     */
    @PostMapping("/method-param-basic-collection")
    @Deprecated
    public String validatedMethodParamBasicCollection(@Valid @Email List<String> emailList) {

        log.info("emailList: {}", emailList);
        return String.valueOf(emailList);
    }

    /**
     * {@link Valid}注解修饰方法参数，bean类型，级联校验
     *
     * @param people {@link People#getWrapper()}被{@link Valid}修饰，触发级联校验，如不用{@link Valid}修饰，则不会校验该属性
     * @return
     */
    @PostMapping("/method-param-bean/deep")
    public String validMethodParamDeep(@Valid @RequestBody People people) {

        log.info("wrapper: {}", people);
        return String.valueOf(people);
    }

    /**
     * {@link Valid}注解修饰方法参数，bean类型
     * 通过{@link #initWebDataBinder(WebDataBinder)}，注册自定义类校验器{@link MoneyValidator}
     *
     * @param money 实际使用了自定义类校验器{@link MoneyValidator#validate(Object, Errors)} (Object, Errors)}校验{@link Money}
     * @return
     */
    @PostMapping("/method-param-bean/validator")
    public String validMethodParamBeanValidator(@Valid @RequestBody Money money) {

        log.info("money: {}", money);
        return String.valueOf(money);
    }

    /**
     * @param binder 在此控制器内，当方法参数为 money 时执行此方法初始化{@link WebDataBinder}；使用{@link ws.spring.validate.config.CustomWebBindingInitializer#initBinder(WebDataBinder)} 进行初始化更方便
     */
//    @InitBinder("money")
    public void initWebDataBinder(WebDataBinder binder) {

        binder.addValidators(new MoneyValidator());
    }
}
