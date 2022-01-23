package ws.spring.validate.hiddenskills.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * 继承或实现接口时修改方法约束
 * @author WindShadow
 * @date 2021-11-20.
 */

@Slf4j
@Validated
@Service
public class ChangeConstraintWhenExtends implements CustomService{

    /**
     * 修改方法参数验证约束
     *
     * @param number
     * @deprecated 检验时抛出{@link javax.validation.ConstraintDeclarationException}约束声明异常
     *
     */
    @Override
    @Deprecated
    public void doSomethingParam(@Min(100) Integer number) {
        log.info("number: {}",number);
    }

    /**
     * 改方法返回值验证约束
     *
     * @return
     * @deprecated 检验时抛出{@link javax.validation.ConstraintDeclarationException}约束声明异常
     */
    @NotBlank
    @Override
    @Deprecated
    public String doSomethingReturn() {
        return " ";
    }

    /**
     * 继承接口，不改方法返回值验证约束
     * @return
     * @deprecated 检验时抛出{@link javax.validation.ConstraintDeclarationException}约束声明异常
     */
    @Override
    @Deprecated
    public /* @Min(10) */ int returnInt() {
        return 0;
    }
}
