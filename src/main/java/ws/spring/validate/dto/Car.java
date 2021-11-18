package ws.spring.validate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ws.spring.validate.annotation.Color;

/**
 * @author WindShadow
 * @version 2021-11-14.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    @Color
    private String color;
}
