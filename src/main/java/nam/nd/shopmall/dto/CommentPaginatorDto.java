package nam.nd.shopmall.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @author nam.nd
 * @created 19/06/2021 - 11:56 PM
 */

@Getter
@Setter
public class CommentPaginatorDto extends BaseSearch{

    @NotEmpty
    private String productId;
}
