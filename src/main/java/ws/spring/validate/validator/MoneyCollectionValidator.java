package ws.spring.validate.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ws.spring.validate.pojo.Money;

import java.util.Collection;

/**
 * @author WindShadow
 * @date 2021-11-20.
 */

@Component
@Deprecated
public class MoneyCollectionValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return isCollection(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (target instanceof Collection) {

            Collection collection = ((Collection)target);
            int i = 0;
            for (Object o : collection) {

                if (o instanceof Money) {

                    // todo 难
                }
                i++;
            }
        }
    }

    protected boolean isCollection(Class<?> clazz) {

        return Collection.class.isAssignableFrom(clazz);
    }
}
