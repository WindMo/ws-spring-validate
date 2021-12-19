package ws.spring.validate.hiddenskills;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.pojo.Box;
import ws.spring.validate.pojo.Person;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WindShadow
 * @date 2021-11-19.
 */

@Slf4j
public class ValidateGenericsTests extends WsSpringValidateApplicationTests {

    @Autowired
    public ValidateGenerics serviceBean;

    @Autowired
    public CustomValidateGenerics customValidateGenericsBean;

    @Test
    public void validateGenericsOfIntegerCollection() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class,
                () -> serviceBean.validateGenericsOfIntegerCollection(Arrays.asList(10,100,200,null))); // false true true true
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateGenericsOfStringCollection() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class,
                () -> serviceBean.validateGenericsOfStringCollection(Arrays.asList("abc","","  ",null))); // true false false false
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateGenericsOfEmbeddedCollection() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class,
                () -> serviceBean.validateGenericsOfEmbeddedCollection(Arrays.asList(
                        Collections.singletonList(new Object()), // true
                        Collections.emptyList(),  // false
                        null // false
                )));
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateGenericsOfBeanCollection() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class,
                () -> serviceBean.validateGenericsOfBeanCollection(Arrays.asList(
                        new Person("123@qq.com"),// true
                        new Person("123"), // false
                        null))); // true
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateGenericsOfEmbeddedIntegerCollection() {

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class,
                () -> serviceBean.validateGenericsOfEmbeddedIntegerCollection(Arrays.asList(
                        Collections.singletonList(1), // false
                        Collections.singletonList(100),  // true
                        Collections.singletonList(200),  // true
                        null // true
                )));
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateGenericsOfMapIntegerKey() {

        Map<Integer,Object> map = new HashMap<>();
        Object o = new Object();
        map.put(10,o); // false
        map.put(100,o); // true
        map.put(200,o); // true
        map.put(null,o); // true

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.validateGenericsOfMapIntegerKey(map));
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateGenericsOfMapIntegerValue() {

        Map<Object,Integer> map = new HashMap<>();
        map.put(new Object(),10); // false
        map.put(new Object(),100); // true
        map.put(new Object(),200); // true
        map.put(new Object(),null); // true

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.validateGenericsOfMapIntegerValue(map));
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateGenericsOfMapBeanKey() {

        Map<Person,Object> map = new HashMap<>();
        Object o = new Object();
        map.put(new Person("123"),o); // false
        map.put(null,o); // true

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.validateGenericsOfMapBeanKey(map));
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    @Test
    public void validateGenericsOfMapBeanValue() {

        Map<Object,Person> map = new HashMap<>();
        map.put(new Object(),new Person("123")); // false
        map.put(new Object(),null); // true

        ConstraintViolationException e = Assertions.assertThrows(ConstraintViolationException.class, () -> serviceBean.validateGenericsOfMapBeanValue(map));
        log.info("ConstraintViolationException: {}",e.getMessage());
    }

    /**
     * 失败，抛出约束声明异常 ==> Caused by: javax.validation.ConstraintDeclarationException: HV000197: No value extractor found for type parameter 'T' of type ws.spring.validate.dto.Box
     *
     */
    @Test
    public void validateGenericsOfJavaBean() {

        Box<String> box = new Box<>("  ");
        ConstraintDeclarationException e = Assertions.assertThrows(ConstraintDeclarationException.class, () -> customValidateGenericsBean.validateGenericsOfJavaBean(box));
        log.info("ConstraintDeclarationException: {}",e.getMessage());
    }
}
