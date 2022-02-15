package ws.spring.validate.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import ws.spring.validate.group.CompanyGroup;

import javax.validation.constraints.Email;

/**
 * @author WindShadow
 * @version 2022-02-15.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {

    @Length(min = 3)
    private String address;

    @Email(groups = CompanyGroup.Chain.class)
    private String email;
}
