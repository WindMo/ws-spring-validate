package ws.spring.validate.support;

import javax.validation.ConstraintValidatorContext;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author WindShadow
 * @version 2021-12-16.
 */

@SuppressWarnings({"rawtypes"})
public class EnumRangeRangeConstraintValidator extends AbstractElementRangeConstraintValidator<EnumRange,Enum> {

    private Class<? extends Enum> type;

    @Override
    public boolean isValid(Enum value, ConstraintValidatorContext context) {

        checkType(value);
        return super.isValid(value, context);
    }

    @SuppressWarnings({"unchecked"})
    @Override
    protected Set<Enum> getElements(EnumRange enumRange) {

        this.type = enumRange.type();
        String[] elements = enumRange.elements();
        EnumSet enumSet = EnumSet.noneOf(type);
        for (String element : elements) {

            Enum e = Enum.valueOf(type,element);
            enumSet.add(e);
        }
        return enumSet;
    }

    private void checkType(Enum value) {

        if (!type.isInstance(value)) {

            throw new IllegalStateException("This enumeration type <" + value.getClass().getName() + "> does not match the expected enumeration type <" + type.getName() + ">");
        }
    }
}
