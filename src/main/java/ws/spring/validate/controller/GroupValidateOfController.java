package ws.spring.validate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ws.spring.validate.pojo.Computer;
import ws.spring.validate.group.Group;

/**
 * Controller控制器分组校验，关键：参数上的{@link Validated#value()}注解内的value值指定组class
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

    @PostMapping("/bean")
    public String groupValidateBeanInsert(@Validated(Group.Insert.class) @RequestBody Computer computer) {

        log.info("computer: {}",computer);
        return String.valueOf(computer);
    }

    @PutMapping("/bean")
    public String groupValidateBeanUpdate(@Validated(Group.Update.class) @RequestBody Computer computer) {

        log.info("computer: {}",computer);
        return String.valueOf(computer);
    }
}
