package nam.nd.shopmall.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import nam.nd.shopmall.validator.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author nam.nd
 * @created 17/06/2021 - 8:01 PM
 */

@Getter
@Setter
public class ProductDto implements Serializable {


    @NumberFormat
    private String id;

    @NotEmpty
    @Size(max = 100)
    private String productName;

    private String price;

    @Size(max = 50)
    @NotEmpty
    private String productStatus;

    @NumberFormat
    @NotEmpty
    private String categoryId;

    @NumberFormat
    @NotEmpty
    private String supplierId;

    @Size(max = 200)
    private String urlImage;

    @Size(max = 5000)
    private String description;

    private String timeUpdate;
}
