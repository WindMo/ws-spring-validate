package ws.spring.validate.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import java.util.Collection;

/**
 * @author WindShadow
 * @date 2021-11-20.
 */

//@Component
public class MoneyCollectionValidator extends MoneyValidator {


    @Override
    public boolean supports(Class<?> clazz) {
        return super.supports(clazz) || isCollection(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (target instanceof Collection) {

            ((Collection)target).forEach(t -> super.validate(t,errors));
        } else {
            super.validate(target, errors);
        }

    }

    protected boolean isCollection(Class<?> clazz) {

        return Collection.class.isAssignableFrom(clazz);
    }
}
