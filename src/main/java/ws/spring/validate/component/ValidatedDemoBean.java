package ws.spring.validate.component;

import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * 使用{@link Validated} 修饰bean，在IOC创建bean时进行校验
 * @author WindShadow
 * @version 2021-11-14.
 */

@Validated
@Component
@ConfigurationProperties(prefix = "validated.bean")
@ToString
public class ValidatedDemoBean {

    @NotBlank
    @Setter
    private String notblank;
}
