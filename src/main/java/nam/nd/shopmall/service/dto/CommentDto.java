package nam.nd.shopmall.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @author nam.nd
 * @created 19/06/2021 - 1:34 PM
 */

@Getter
@Setter
public class CommentDto {

    private String id;

    @NotEmpty
    private String content;

    @NotEmpty
    private String productId;

    private String parentId;

    private String timeUpdate;

    @NotEmpty
    private String userId;
}
