//package ws.spring.validate.validator;
//
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import ws.spring.validate.dto.Money;
//
//import java.util.Collection;
//
///**
// * @author WindShadow
// * @date 2021-11-20.
// */
//
//@Component
//public class MoneyCollectionValidator extends MoneyValidator {
//
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return super.supports(clazz) || isCollection(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//
//        if (target instanceof Collection) {
//
//            Collection collection = ((Collection)target);
//            for (Object o : collection) {
//
//                if (o instanceof Money) {
//                    super.validate(o,errors);
//                }
//            }
//        } else {
//            super.validate(target, errors);
//        }
//    }
//
//    protected boolean isCollection(Class<?> clazz) {
//
//        return Collection.class.isAssignableFrom(clazz);
//    }
//}
