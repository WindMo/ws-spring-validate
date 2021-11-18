package ws.spring.validate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailWrapper {

    @Email
    private String emailWrapper;
}