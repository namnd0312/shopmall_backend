package nam.nd.shopmall.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @author nam.nd
 * @created 19/06/2021 - 12:25 AM
 */

@Getter
@Setter
public class ProductPaginatorDto extends BaseSearch {

    @NotEmpty
    private String status;
}
