package ws.spring.validate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ws.spring.validate.pojo.EmailWrapper;
import ws.spring.validate.pojo.Person;
import ws.spring.validate.util.ValidateUtils;

/**
 * 绑定结果{@link BindingResult}的作用
 * @author WindShadow
 * @version 2021-11-14.
 */
@Slf4j
@RestController
public class BindingResultController {

    /**
     * bean参数验证 + BindingResult 处理结果
     * @param person
     * @param bindingResult 参数绑定结果
     * @return
     */
    @PostMapping("/binding-result")
    public String bindingResult(@Validated @RequestBody Person person, BindingResult bindingResult) {

        // 校验person失败，可获取得bindingResult，正常进入此方法
        log.info("person: {}",person);
        String bindingResultDetail = ValidateUtils.cleanUpBindingResult(bindingResult);
        log.info("bindingResultDetail: {}",bindingResultDetail);
        return person + " >>> " + bindingResultDetail;
    }

    /**
     * bean参数验证 + BindingResult 处理结果；多个参数
     * @param person
     * @param emailWrapper 自动从query参数获取 emailWrapper 参数封装为{@link EmailWrapper}
     * @param bindingResult 参数绑定结果
     * @return
     */
    @PostMapping("/binding-result/multiple")
    public String bindingResultMultipleParam(@Validated @RequestBody Person person, @Validated EmailWrapper emailWrapper, BindingResult bindingResult) {

        // 校验person失败，抛出异常。无法进入此方法
        // 校验emailWrapper失败，可获取得bindingResult，正常进入此方法
        // 可见bindingResult作为处理器参数，只能获得最后一个参数的绑定结果，在那之前如果发生了绑定错误，则走抛异常流程
        log.info("person: {}, eamilWrapper: {}",person,emailWrapper);
        String bindingResultDetail = ValidateUtils.cleanUpBindingResult(bindingResult);
        log.info("bindingResultDetail: {}",bindingResultDetail);
        return person + " | " + emailWrapper + " >>> " + bindingResultDetail;
    }
}
