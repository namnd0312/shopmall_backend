package nam.nd.shopmall.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import nam.nd.shopmall.exception.LogicException;
import nam.nd.shopmall.service.ProductService;
import nam.nd.shopmall.service.dto.ProductDto;
import nam.nd.shopmall.service.dto.ProductPaginatorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:47 PM
 */

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping("/update-product")
    public ResponseEntity<Void> updateProduct(@Valid @RequestBody ProductDto dto) throws LogicException {
        productService.update(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create-product")
    public ResponseEntity<Void> saveProduct(@Valid @RequestBody ProductDto dto) throws LogicException {
        productService.create(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-product/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) throws LogicException {
        ProductDto productDtoList = productService.findById(id);
        return new ResponseEntity<>(productDtoList,HttpStatus.OK);
    }

    @PostMapping("/get-all-product")
    public ResponseEntity<?> getAllProduct(@Valid @RequestBody ProductPaginatorDto dto) throws JsonProcessingException {
        productService.finAllProductByProductStatus(dto);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id") Long id) throws LogicException {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
