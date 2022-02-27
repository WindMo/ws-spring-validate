package ws.spring.validate.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ws.spring.validate.group.Group;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author WindShadow
 * @version 2022-02-27.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class House {

    @NotNull(groups = Group.Update.class)
    @Null(groups = Group.Insert.class)
    private Integer id;

    @NotNull(groups = {Group.Insert.class, Group.Update.class})
    private String serialNumber;
}
