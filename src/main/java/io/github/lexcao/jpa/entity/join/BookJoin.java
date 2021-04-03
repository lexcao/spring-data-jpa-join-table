package io.github.lexcao.jpa.entity.join;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "book")
public class BookJoin {

    @Id
    private String id;

    @Column(name = "publish_time")
    private LocalDateTime publishTime;

    @ManyToOne
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Author author;
    @OneToOne
    @JoinColumn(name = "review_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Review review;

    @Data
    @Entity
    @Table(name = "author")
    public static class Author {
        @Id
        private String id;
        private String name;
    }

    @Data
    @Entity
    @Table(name = "review")
    public static class Review {
        @Id
        private String id;
        private Integer score;
    }
}
