package ws.spring.validate.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import ws.spring.validate.group.CompanyGroup;
import ws.spring.validate.group.Group;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.ConvertGroup;

/**
 * @author WindShadow
 * @version 2021-11-17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Computer {

    @Null(groups = Group.Insert.class) // 新增时必定为空
    @NotNull(groups = Group.Update.class) // 更新时必定不为空
    private Integer id;

    /**
     * 未指定分组的约束，默认属于 {@linkplain javax.validation.groups.Default default组}
     */
    @Length(min = 100)
    private String name;

    /**
     * 级联校验时，{@link ConvertGroup}将{@linkplain Group.Insert Insert组}转为{@linkplain CompanyGroup.Chain Chain组}往下校验
     */
    @Valid
    @ConvertGroup(from = Group.Insert.class, to = CompanyGroup.Chain.class)
    private Company company;
}
