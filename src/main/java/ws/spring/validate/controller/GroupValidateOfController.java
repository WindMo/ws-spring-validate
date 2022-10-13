package ws.spring.validate.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ws.spring.validate.group.Group;
import ws.spring.validate.pojo.Computer;
import ws.spring.validate.pojo.Pot;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;

/**
 * Controller控制器分组校验，关键：参数上的{@link Validated#value()}注解内的value值指定组class
 *
 * @author WindShadow
 * @version 2021-11-17.
 * @see Computer 见其内部属性的约束注解所制定的分组
 * @see Group.Insert
 * @see Group.Update
 */

@Slf4j
@RestController
@RequestMapping("/validated/group")
public class GroupValidateOfController {

    /**
     * 校验{@linkplain Group.Insert Insert}组，
     * 校验{@link Computer#getId()}的{@link Null}约束，
     * 不校验{@link Computer#getName()}上的任何约束
     *
     * @param computer computer
     * @return String
     */
    @PostMapping("/bean")
    public String groupValidateBeanInsert(@Validated({Group.Insert.class}) @RequestBody Computer computer) {

        log.info("computer: {}", computer);
        return String.valueOf(computer);
    }

    /**
     * 校验{@linkplain Group.Update Update}组，
     * 校验{@link Computer#getId()}的{@link NotNull}约束，
     * 不校验{@link Computer#getName()}上的{@link Length}约束
     *
     * @param computer computer
     * @return String
     */
    @PutMapping("/bean")
    public String groupValidateBeanUpdate(@Validated(Group.Update.class) @RequestBody Computer computer) {

        log.info("computer: {}", computer);
        return String.valueOf(computer);
    }

    /**
     * 校验{@linkplain Group.Insert Insert}组与{@linkplain Default default组}，
     * 校验{@link Computer#getId()}的{@link Null}约束，
     * 校验{@link Computer#getName()}上的{@link Length}约束
     *
     * @param computer computer
     * @return String
     */
    @PostMapping("/v2/bean")
    public String groupValidateBeanInsertV2(@Validated({Group.Insert.class, Default.class}) @RequestBody Computer computer) {

        log.info("computer: {}", computer);
        return String.valueOf(computer);
    }

    /**
     * 校验{@linkplain Group.Insert Insert}组与{@linkplain Default default组}，
     * 校验{@link Computer#getId()}的{@link Null}约束，
     * 校验{@link Computer#getName()}上的{@link Length}约束
     *
     * @param computer computer
     * @return String
     */
    @PostMapping("/v3/bean")
    public String groupValidateBeanInsertV3(
            @Validated({Group.Insert.class})
//            @ConvertGroup(from = Group.Insert.class, to = CompanyGroup.Chain.class) // 此处的ConvertGroup无效
            @RequestBody Computer computer) {

        log.info("computer: {}", computer);
        return String.valueOf(computer);
    }

    @PostMapping("/dgsp/bean")
    public String groupValidateForDgsp(@Validated @RequestBody Pot pot) {

        log.info("pot: {}", pot);
        return String.valueOf(pot);
    }
}
