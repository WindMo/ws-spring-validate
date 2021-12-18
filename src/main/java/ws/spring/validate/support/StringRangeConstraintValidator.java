package ws.spring.validate.support;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

public class StringRangeConstraintValidator extends AbstractElementRangeConstraintValidator<StringRange,String> {

    @Override
    protected Set<String> getElements(StringRange stringRange) {

       return Stream.of(stringRange.value()).collect(Collectors.toSet());
    }
}
