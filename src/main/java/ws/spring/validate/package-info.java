/**
 * Spring校验体系示例与解读
 * @author WindShadow
 * @version 2021-11-14.
 */

package ws.spring.validate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ws.spring.validate.component.ValidDemoBean;
import ws.spring.validate.component.ValidatedDemoBean;
import ws.spring.validate.controller.BasicTypeValidatedController;
import ws.spring.validate.controller.BeanValidatedController;
import ws.spring.validate.util.ValidateUtils;

@Slf4j
@Component
class ValidateHelper implements ApplicationContextAware, ApplicationRunner {

    private ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        printBean(ValidDemoBean.class);
        printBean(ValidatedDemoBean.class); // Spring创建bean时对其进行校验，对其进行了代理

        printBean(BeanValidatedController.class); // Controller 本身支持方法上校验bean，对其不代理
        printBean(BasicTypeValidatedController.class); // Controller 上使用了Validated注解，对其进行了代理
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
        helpValidateUtils();
    }

    private void helpValidateUtils() {

        ValidateUtils.setMessageSource(this.applicationContext.getBean(MessageSource.class));
    }

    private void printBean(Class<?> clazz) {

        Object bean = this.applicationContext.getBean(clazz);
        // 打印bean 预期Class 真实Class bean.toString 内容
        log.info("Bean - Class: {} RelClass: {} ToString: {}",clazz,bean.getClass(),bean);
    }

}

