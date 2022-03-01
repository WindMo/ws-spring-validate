package ws.spring.validate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.bind.support.WebBindingInitializer;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * web数据绑定期间的配置
 *
 * @author WindShadow
 * @version 2021-11-16.
 */
@Slf4j
@Configuration
public class CustomWebBindingInitializer extends ConfigurableWebBindingInitializer implements WebBindingInitializer {

    @Autowired
    protected List<Validator> validators;

    @PostConstruct
    public void init() {
        // 过滤Spring内置校验器Controller校验会失效
//        validators = validators.stream().filter(validator -> !(validator instanceof SmartValidator)).collect(Collectors.toList());
    }

    /**
     * 通过遍历注入{@link #validators}的集合，如果支持当前绑定对象的类型，则加入绑定器，
     * 如果添加了不支持的校验器，则在校验时将抛出状态异常
     *
     * @param binder
     */
    @Override
    public void initBinder(WebDataBinder binder) {
        super.initBinder(binder);

        Object target = binder.getTarget();
        Class<?> clazz = target == null ? null : target.getClass();
        validators.stream().filter(validator -> validator.supports(clazz)).forEach(binder::addValidators);
    }
}
