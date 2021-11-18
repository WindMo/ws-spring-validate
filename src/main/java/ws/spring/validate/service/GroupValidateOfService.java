package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.group.Group;

import javax.validation.constraints.NotBlank;

/**
 * @author WindShadow
 * @version 2021-11-17.
 */

@Slf4j
@Validated(Group.Query.class)
@Service
public class GroupValidateOfService {

    public String groupValidateBasicQuery(@NotBlank(groups = Group.Query.class) String keyword) {

        log.info("keyword: {}",keyword);
        return String.valueOf(keyword);
    }

    public String groupValidateBasicDelete(@NotBlank(groups = Group.Delete.class) String keyword) {

        log.info("keyword: {}",keyword);
        return String.valueOf(keyword);
    }
}
