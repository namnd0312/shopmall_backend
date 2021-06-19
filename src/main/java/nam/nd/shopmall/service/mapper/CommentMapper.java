package nam.nd.shopmall.service.mapper;

import nam.nd.shopmall.model.Comment;
import nam.nd.shopmall.service.dto.CommentDto;
import nam.nd.shopmall.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author nam.nd
 * @created 19/06/2021 - 1:36 PM
 */

@Component
public class CommentMapper {

    public Comment toEntity(CommentDto dto) {

        if (dto == null) {
            return null;
        }

        Comment entity = new Comment();

        Util.trimStringValuesOfObject(dto);

        BeanUtils.copyProperties(dto, entity);

        if (!StringUtils.isEmpty(dto.getId())) {
            entity.setId(Util.stringToLong(dto.getId()));
        }

        if (!StringUtils.isEmpty(dto.getParentId())) {
            entity.setParentId(Util.stringToLong(dto.getParentId()));
        }

        if (!StringUtils.isEmpty(dto.getProductId())) {
            entity.setProductId(Util.stringToLong(dto.getProductId()));
        }

        if(!StringUtils.isEmpty(dto.getUserId())){
            entity.setUserId(Util.stringToLong(dto.getUserId()));
        }

        entity.setTimeUpdate(Instant.now());

        return entity;
    }


    public CommentDto toDto(Comment entity) {

        if (entity == null) {
            return null;
        }

        Util.trimStringValuesOfObject(entity);

        CommentDto dto = new CommentDto();

        BeanUtils.copyProperties(dto, entity);

        if (!StringUtils.isEmpty(dto.getId())) {
            dto.setId(Util.longToString(entity.getId()));
        }

        if (!StringUtils.isEmpty(dto.getParentId())) {
            dto.setParentId(Util.longToString(entity.getParentId()));
        }

        if (!StringUtils.isEmpty(dto.getProductId())) {
            dto.setParentId(Util.longToString(entity.getParentId()));
        }

        if (entity.getTimeUpdate() != null) {
            dto.setTimeUpdate(Util.instantToString(entity.getTimeUpdate()));
        }

        if(!StringUtils.isEmpty(dto.getUserId())){
            dto.setUserId(Util.longToString(entity.getUserId()));
        }

        entity.setTimeUpdate(Instant.now());

        return dto;
    }
}
