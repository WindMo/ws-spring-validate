package ws.spring.validate.component;

import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * 使用{@link Valid} 修饰bean，在IOC创建bean时进行校验
 * 不起作用
 * @author WindShadow
 * @version 2021-11-14.
 */

@Valid // 不起作用
@Component
@ConfigurationProperties(prefix = "valid.bean")
@ToString
public class ValidDemoBean {

    @NotBlank
    private String notblank;
}
