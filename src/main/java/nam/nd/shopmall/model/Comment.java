package nam.nd.shopmall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author nam.nd
 * @created 16/06/2021 - 11:10 PM
 */

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "time_update", nullable = false)
    private Instant timeUpdate;

    @Column(name = "time_create", nullable = false)
    private Instant timeCreate;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "parent_id")
    private Long parentId;
}
