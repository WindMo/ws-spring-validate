package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.group.Group;
import ws.spring.validate.pojo.House;

import javax.validation.GroupSequence;
import javax.validation.Valid;

/**
 * @author WindShadow
 * @version 2022-02-27.
 */

@Slf4j
@Validated(GroupSequenceValidateService.MyGroup.class)
@Service
public class GroupSequenceValidateService {

    public void groupValidateGroupSequence(@Valid House house) {

        log.info("house: {}", house);
    }

    /**
     * 定义一个组并指定校验顺序
     */
    @GroupSequence({Group.Insert.class, Group.Update.class})
    interface MyGroup {
    }
}
