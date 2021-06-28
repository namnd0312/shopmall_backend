package nam.nd.shopmall.controller;

import nam.nd.shopmall.exception.LogicException;
import nam.nd.shopmall.service.CommentService;
import nam.nd.shopmall.dto.CommentDto;
import nam.nd.shopmall.dto.CommentPaginatorDto;
import nam.nd.shopmall.dto.ProductPaginatorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:47 PM
 */

@RequestMapping("/api")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PutMapping("/update-comment")
    public ResponseEntity<Void> updateComment(@Valid @RequestBody CommentDto dto) throws LogicException {
        commentService.updateComment(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create-comment")
    public ResponseEntity<Void> saveComment(@Valid @RequestBody CommentDto dto) throws LogicException {
        commentService.createComment(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-comment/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable("id") Long id) throws LogicException {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/get-comments")
    public ResponseEntity<CommentPaginatorDto> getAllComment(@Valid @RequestBody CommentPaginatorDto dto) {
        commentService.getAllCommentByProductId(dto);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}
