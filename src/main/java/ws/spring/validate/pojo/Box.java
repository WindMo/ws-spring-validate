package ws.spring.validate.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 带泛型的实体
 *
 * @author WindShadow
 * @date 2021-11-20.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Box<T> {

    private T entity;
}
