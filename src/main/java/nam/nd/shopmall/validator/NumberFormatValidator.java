package nam.nd.shopmall.validator;



import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class mapping with {@link NumberFormat}.
 *
 * @author namnd
 */
public class NumberFormatValidator implements ConstraintValidator<NumberFormat, String> {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || (s.trim().isEmpty())) {
            return true;
        }

        if(!StringUtils.isEmpty(s)){
            Pattern pattern = Pattern.compile("[^0-9]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(s);
            boolean result = matcher.find();
            return !result;
        }
        return false;
    }
}
