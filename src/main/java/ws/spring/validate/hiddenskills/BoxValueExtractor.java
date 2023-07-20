package ws.spring.validate.hiddenskills;

import org.hibernate.validator.internal.engine.valueextraction.ValueExtractorDescriptor;
import ws.spring.validate.pojo.Box;

import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.ValueExtractor;

/**
 * {@link Box}的值提取器
 * @author WindShadow
 * @version 2023-07-20.
 */

public class BoxValueExtractor implements ValueExtractor<Box<@ExtractedValue ?>> {

    static final String NODE_NAME = "<Box entity>";

    public static final ValueExtractorDescriptor DESCRIPTOR = new ValueExtractorDescriptor(new BoxValueExtractor());

    @Override
    public void extractValues(Box<?> originalValue, ValueReceiver receiver) {
        receiver.value(NODE_NAME, originalValue.getEntity());
    }
}
