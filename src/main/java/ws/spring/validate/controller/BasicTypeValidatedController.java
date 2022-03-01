package ws.spring.validate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.spring.validate.group.Group;

import javax.validation.constraints.Email;

/**
 * 在Controller控制器中校验【简单类型】，关键：类上加{@link Validated}注解
 * 写法和{@link ws.spring.validate.service.ValidateServiceMethodParam}是一样的
 *
 * @author WindShadow
 * @version 2021-11-15.
 * @see ws.spring.validate.service.ValidateServiceMethodParam
 */

@Slf4j
@Validated(Group.Query.class) // 感觉导致Controller分组校验不灵活
@RestController
@RequestMapping("/validated/group")
public class BasicTypeValidatedController {

    /**
     * 校验方法参数，简单类型
     *
     * @param email
     * @return
     * @see BeanValidatedController#validatedMethodParamBasic(String) 对比
     */
    @GetMapping("/basic-hit")
    public String validatedMethodParamBasicHit(@Email(groups = Group.Query.class) String email) {

        log.info("email: {}", email);
        return String.valueOf(email);
    }

    /**
     * 校验方法参数，简单类型
     *
     * @param email
     * @return
     * @see BeanValidatedController#validatedMethodParamBasic(String) 对比
     */
    @GetMapping("/basic-miss")
    public String validatedMethodParamBasicMiss(@Email(groups = Group.Update.class) String email) {

        log.info("email: {}", email);
        return String.valueOf(email);
    }
}
