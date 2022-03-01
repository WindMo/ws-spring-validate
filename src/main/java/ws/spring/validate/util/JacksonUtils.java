package ws.spring.validate.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author WindShadow
 * @date 2021-11-18.
 */

public class JacksonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> T toObject(String jsonText, Class<T> clazz) {

        try {
            return OBJECT_MAPPER.readValue(jsonText, clazz);
        } catch (JsonProcessingException e) {
            throw new UnsupportedOperationException("json转换失败", e);
        }
    }

    public static <T> String toJson(T object) {

        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new UnsupportedOperationException("json转换失败", e);
        }
    }
}
