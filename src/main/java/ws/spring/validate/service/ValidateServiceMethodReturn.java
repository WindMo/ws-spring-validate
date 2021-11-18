package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.dto.Person;
import ws.spring.validate.dto.User;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.List;

/**
 * 校验service bean方法返回值测试service
 * Spring Bean中支持使用{@link Validated}修饰类，使用{@link Valid}或约束注解（如{@link NotBlank}）修饰【方法返回值】，其方法在被调用前，校验【方法返回值】
 * 而使用{@link Valid}修饰类，使用{@link Validated}修饰方法返回值则无效
 * @author WindShadow
 * @version 2021-11-15.
 */

@Slf4j
@Validated
@Service
public class ValidateServiceMethodReturn {

    /**
     * 校验bean；使用{@link Valid}修饰方法
     */
    @Valid
    public Person validateBeanByValidAnnotation() {

        Person person = new Person("123");
        log.info("person: {}",person);
        return person;
    }

    /**
     * 校验bean；使用{@link Validated}修饰方法反而无用
     * @deprecated 无效
     */
    @Validated
    @Deprecated
    public User validateBeanByValidatedAnnotation() {
        User user = new User("123");
        log.info("user: {}",user);
        return user;
    }

    /**
     * 校验基本类型
     */
    @NotBlank
    public String validateBasic() {

        String str = "  ";
        log.info("str: {}",str);
        return str;
    }

    /**
     * 校验bean集合；使用{@link Valid}修饰方法
     */
    @Valid
    public List<Person> validateCollectionByValidAnnotation() {

        List<Person> personList = Collections.singletonList(new Person("123"));
        log.info("personList: {}",personList);
        return personList;
    }

    /**
     * 校验bean集合；使用{@link Validated}修饰方法反而无用
     * @deprecated 无效
     */
    @Validated
    @Deprecated
    public List<User> validateCollectionByValidatedAnnotation() {

        List<User> userList = Collections.singletonList(new User("123"));
        log.info("userList: {}",userList);
        return userList;
    }
}
