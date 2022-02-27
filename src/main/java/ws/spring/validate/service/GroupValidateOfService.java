package ws.spring.validate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.group.CompanyGroup;
import ws.spring.validate.group.Group;
import ws.spring.validate.pojo.Company;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

/**
 * @author WindShadow
 * @version 2021-11-17.
 */

@Slf4j
@Validated({Group.Query.class, Default.class})
@Service
public class GroupValidateOfService {

    public void groupValidateBasicQuery(@NotBlank(groups = Group.Query.class) String keyword) {

        log.info("keyword: {}", keyword);
    }

    public void groupValidateBasicDelete(@NotBlank(groups = Group.Delete.class) String keyword) {

        log.info("keyword: {}", keyword);
    }

    /**
     * {@link ConvertGroup}将{@linkplain Group.Query Query组}转为{@linkplain CompanyGroup.Chain Chain组}往下校验
     *
     * @param company company
     */
    public void groupValidateConvertGroup(@Valid @ConvertGroup(from = Group.Query.class, to = CompanyGroup.Chain.class) Company company) {

        log.info("company: {}", company);
    }
}
