package ws.spring.validate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author WindShadow
 * @version 2021-11-14.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class People {

    @NotBlank
    private String name;

    @Valid // Valid 可级联校验
    private EmailWrapper wrapper;
}
