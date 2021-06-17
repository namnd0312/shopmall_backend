package nam.nd.shopmall.service.mapper;

import nam.nd.shopmall.util.Util;
import nam.nd.shopmall.model.Product;
import nam.nd.shopmall.service.dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


import java.io.Serializable;
import java.time.Instant;

/**
 * @author nam.nd
 * @created 17/06/2021 - 8:06 PM
 */

@Component
public class ProductMapper implements Serializable {

    public ProductDto toDto(Product entity){

        if (entity == null) {
            return null;
        }

        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(entity, dto);

        if(entity.getId() != null){
            dto.setId(Util.longToString(entity.getId()));
        }

        if(entity.getPrice() != null){
            dto.setPrice(Util.doubleToString(entity.getPrice()));
        }

        if(entity.getSupplierId() != null){
            dto.setSupplierId(Util.longToString(entity.getSupplierId()));
        }

        if(entity.getId() != null){
            dto.setId(Util.longToString(entity.getId()));
        }

        if(entity.getTimeUpdate() != null){
            dto.setTimeUpdate(Util.instantToString(entity.getTimeUpdate()));
        }

        return dto;
    }

    public Product toEntity(ProductDto dto){

        if (dto == null) {
            return null;
        }

        Util.trimStringValuesOfObject(dto);

        Product entity = new Product();
        BeanUtils.copyProperties(dto, entity);

        if(!StringUtils.isEmpty(dto.getId())){
            entity.setId(Util.stringToLong(dto.getId()));
        }

        if(!StringUtils.isEmpty(dto.getPrice())){
            entity.setPrice(Util.stringToDouble(dto.getPrice()));
        }

        if(!StringUtils.isEmpty(dto.getCategoryId())){
            entity.setCategoryId(Util.stringToLong(dto.getCategoryId()));
        }

        if(!StringUtils.isEmpty(dto.getSupplierId())){
            entity.setSupplierId(Util.stringToLong(dto.getSupplierId()));
        }

        entity.setTimeUpdate(Instant.now());

        return entity;
    }
}
