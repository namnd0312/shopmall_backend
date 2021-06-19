package nam.nd.shopmall.service;

import nam.nd.shopmall.exception.LogicException;
import nam.nd.shopmall.service.dto.CommentDto;
import nam.nd.shopmall.service.dto.CommentPaginatorDto;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:49 PM
 */
public interface CommentService {

    void createComment(CommentDto dto);

    void updateComment(CommentDto dto) throws LogicException;

    void deleteComment(Long id) throws LogicException;

    void getAllCommentByProductId(CommentPaginatorDto dto);

}
