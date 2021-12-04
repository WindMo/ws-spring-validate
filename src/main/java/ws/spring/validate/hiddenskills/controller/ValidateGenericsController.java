package ws.spring.validate.hiddenskills.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.spring.validate.pojo.Money;
import ws.spring.validate.pojo.Person;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * 在Controller中校验泛型，用法与{@link  ws.spring.validate.hiddenskills.ValidateGenerics}相同，下面仅以简单类型和bean类型的集合作示例
 * @author WindShadow
 * @date 2021-11-20.
 * @see ws.spring.validate.hiddenskills.ValidateGenerics
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/validated/generics")
public class ValidateGenericsController {

    @PostMapping("/integer-collection")
    public String validateGenericsOfIntegerCollection(@RequestBody List<@Min(100) Integer> integerList) {

        log.info("integerList: {}",integerList);
        return String.valueOf(integerList);
    }

    @PostMapping("/bean-collection")
    public String validateGenericsOfBeanCollection(@RequestBody List<@Valid Person> personList) {

        log.info("personList: {}",personList);
        return String.valueOf(personList);
    }

    /**
     * 使用自定义校验器校验泛型，无效
     * @param moneyList
     * @return
     * @deprecated 无效，因为本质是校验集合中的{@link Money}对象内的约束，而{@link Money}类的属性并没有约束
     */
    @PostMapping("/bean-collection-validator")
    @Deprecated
    public String validateGenericsOfBeanCollectionByValidator(@RequestBody List<@Valid Money> moneyList) {

        log.info("moneyList: {}",moneyList);
        return String.valueOf(moneyList);
    }

    /**
     * 无效，同{@link #validateGenericsOfBeanCollectionByValidator(List)}
     *
     * @param moneyList
     * @return
     */
    @PostMapping("/bean-collection-validator2")
    @Deprecated
    public String validateGenericsOfBeanCollectionByValidator2(@RequestBody @Valid List<Money> moneyList) {

        log.info("moneyList: {}",moneyList);
        return String.valueOf(moneyList);
    }
}
