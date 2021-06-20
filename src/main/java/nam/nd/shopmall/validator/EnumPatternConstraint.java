package nam.nd.shopmall.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:51 PM
 */
@Documented
@Constraint(validatedBy = EnumPatternValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface EnumPatternConstraint {
    String regexp();

    String message() default "must macth \"{regexp}\"";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
