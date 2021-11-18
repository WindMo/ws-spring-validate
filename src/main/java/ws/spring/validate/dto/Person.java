package ws.spring.validate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;

/**
 * @author WindShadow
 * @version 2021-11-14.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    @Email
    private String email;
}
