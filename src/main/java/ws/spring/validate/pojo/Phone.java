package ws.spring.validate.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.ScriptAssert;

/**
 * @author WindShadow
 * @version 2022-03-01.
 */

@ScriptAssert(script = "_this.id == null ? true : _this.desc != null", lang = "javascript", message = "{ws.spring.validate.pojo.Phone.message}")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Phone {

    private Integer id;
    private String desc;
}
