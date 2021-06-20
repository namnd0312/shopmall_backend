package nam.nd.shopmall.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * This validation reject value not a number
 * This interface mapping with {@link NumberFormatValidator}.
 * @author namnd
 */

@Documented
@Constraint(validatedBy = NumberFormatValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberFormat {
    String message() default "invalid format number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean isRequired() default true;
}
