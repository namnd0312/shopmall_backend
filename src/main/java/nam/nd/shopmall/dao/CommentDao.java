package nam.nd.shopmall.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import nam.nd.shopmall.service.dto.CommentDto;
import nam.nd.shopmall.service.dto.CommentPaginatorDto;

import java.io.Serializable;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:49 PM
 */
public interface CommentDao extends Serializable, BaseDAO {

    void deleteByParentId(Long parentId);

    void deleteById(Long id);

    void getAllCommentByProductId(CommentPaginatorDto dto);
}
