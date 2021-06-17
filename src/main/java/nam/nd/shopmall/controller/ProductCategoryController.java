package nam.nd.shopmall.controller;

import nam.nd.shopmall.exception.LogicException;
import nam.nd.shopmall.service.ProductService;
import nam.nd.shopmall.service.dto.ProductDto;
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
public class ProductCategoryController {

    @Autowired
    private ProductService productService;

    @PutMapping("/update-product")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDto dto) throws LogicException {
        productService.update(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create-product")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductDto dto) throws LogicException {
        productService.create(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
