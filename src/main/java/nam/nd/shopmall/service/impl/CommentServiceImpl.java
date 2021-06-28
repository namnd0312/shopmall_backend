package nam.nd.shopmall.service.impl;

import nam.nd.shopmall.dao.CommentDao;
import nam.nd.shopmall.enums.MessageEnum;
import nam.nd.shopmall.exception.LogicException;
import nam.nd.shopmall.model.Comment;
import nam.nd.shopmall.service.CommentService;
import nam.nd.shopmall.dto.CommentDto;
import nam.nd.shopmall.dto.CommentPaginatorDto;
import nam.nd.shopmall.service.mapper.CommentMapper;
import nam.nd.shopmall.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:50 PM
 */

@Transactional
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    private final CommentDao commentDao;

    public CommentServiceImpl(CommentMapper commentMapper, CommentDao commentDao) {
        this.commentMapper = commentMapper;
        this.commentDao = commentDao;
    }

    @Override
    public void createComment(CommentDto dto) {
        Comment comment = commentMapper.toEntity(dto);
        comment.setTimeCreate(Instant.now());
        commentDao.save(comment);
    }

    @Override
    public void updateComment(CommentDto dto) throws LogicException {

        if(StringUtils.isEmpty(dto.getId())){
            throw new LogicException(MessageEnum.FIELD_REQUIRED, "id");
        }

        Comment comment = commentDao.findById(Util.stringToLong(dto.getId()), Comment.class).orElse(null);

        if(comment == null){
            throw new LogicException(MessageEnum.RECORD_NOT_EXIST);
        }

        Comment entity = commentMapper.toEntity(dto);
        entity.setTimeCreate(comment.getTimeCreate());
        commentDao.update(entity);
    }

    @Override
    public void deleteComment(Long id) throws LogicException {
        Comment comment = commentDao.findById(id, Comment.class).orElse(null);

        if(comment == null){
            throw new LogicException(MessageEnum.RECORD_NOT_EXIST);
        }

        commentDao.deleteById(id);
        commentDao.deleteByParentId(id);
    }

    @Override
    public void getAllCommentByProductId(CommentPaginatorDto dto) {
        commentDao.getAllCommentByProductId(dto);
    }
}
