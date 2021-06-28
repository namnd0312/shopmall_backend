package nam.nd.shopmall.dto;

import lombok.Getter;
import lombok.Setter;
import nam.nd.shopmall.validator.NumberFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author nam.nd
 * @created 17/06/2021 - 9:58 PM
 */

@Getter
@Setter
public class ChangeProductStatusDto implements Serializable {

    @NotEmpty
    @NumberFormat
    private String id;

    @NotEmpty
    private String status;
}
