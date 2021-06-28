package nam.nd.shopmall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author nam.nd
 * @created 17/06/2021 - 7:37 PM
 */
@Getter
@Setter
@ToString
public abstract class BaseSearch {
    protected Long totalRecords;
    protected Integer page;
    protected Integer totalPages;
    protected Integer pageSize;
    protected List<OrderDTO> orders;
    protected List<?> data;
}

