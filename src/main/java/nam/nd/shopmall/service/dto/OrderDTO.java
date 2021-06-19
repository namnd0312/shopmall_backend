package nam.nd.shopmall.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author nam.nd
 * @created 17/06/2021 - 7:38 PM
 */
@Getter
@Setter
@ToString
public class OrderDTO {
    public static final String DESC = "desc";
    public static final String ASC = "asc";

    private String property;

    @JsonProperty
    private boolean ascending;
}