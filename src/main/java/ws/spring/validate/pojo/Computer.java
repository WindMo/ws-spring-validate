package ws.spring.validate.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import ws.spring.validate.group.Group;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

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
}
