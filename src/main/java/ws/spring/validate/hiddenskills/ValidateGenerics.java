package ws.spring.validate.hiddenskills;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ws.spring.validate.pojo.Person;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

/**
 * 隐藏技巧之校验泛型
 * @author WindShadow
 * @date 2021-11-19.
 * @see ws.spring.validate.service.ValidateServiceMethodParam#validateCollectionByValidAnnotation(List) 对比校验bean集合
 */

@Slf4j
@Validated
@Service
public class ValidateGenerics {

    /**
     * 校验集合简单类型泛型，Integer类型
     *
     * @param integerList
     */
    public void validateGenericsOfIntegerCollection(List<@Min(100) Integer> integerList) {

        log.info("integerList: {}",integerList);
    }

    /**
     * 校验集合简单类型泛型，String类型
     *
     * @param stringList
     */
    public void validateGenericsOfStringCollection(List<@NotBlank String> stringList) {

        log.info("stringList: {}",stringList);
    }

    /**
     * 对比，校验集合bean类型泛型，bean类型
     *
     * @param personList
     * @see ws.spring.validate.service.ValidateServiceMethodParam#validateCollectionByValidAnnotation(List) 一样的效果
     */
    public void validateGenericsOfBeanCollection(List<@Valid Person> personList) {

        log.info("personList: {}",personList);
    }

    /**
     * 校验集合中的集合
     *
     * @param embeddedList
     */
    public void validateGenericsOfEmbeddedCollection(List<@NotEmpty List<Object>> embeddedList) {

        log.info("embeddedList: {}",embeddedList);
    }

    /**
     * 校验集合中的集合中的简单类型
     *
     * @param embeddedIntegerList
     */
    public void validateGenericsOfEmbeddedIntegerCollection(List<List<@Min(100) Integer>> embeddedIntegerList) {

        log.info("embeddedIntegerList: {}",embeddedIntegerList);
    }

    /**
     * 校验map中的key，简单类型
     *
     * @param map
     */
    public void validateGenericsOfMapIntegerKey(Map<@Min(100) Integer,Object> map) {

        log.info("map: {}",map);
    }

    /**
     * 校验map中的value，简单类型
     *
     * @param map
     */
    public void validateGenericsOfMapIntegerValue(Map<Object,@Min(100) Integer> map) {

        log.info("map: {}",map);
    }

    /**
     * 校验map中的key，bean类型
     *
     * @param map
     */
    public void validateGenericsOfMapBeanKey(Map<@Valid Person,Object> map) {

        log.info("map: {}",map);
    }

    /**
     * 校验map中的value，bean类型
     *
     * @param map
     */
    public void validateGenericsOfMapBeanValue(Map<Object,@Valid Person> map) {

        log.info("map: {}",map);
    }
}
