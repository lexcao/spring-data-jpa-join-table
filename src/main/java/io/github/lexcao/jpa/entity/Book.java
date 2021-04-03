package io.github.lexcao.jpa.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table
@Entity
@Builder
public class Book {
    @Id
    private String id;

    @Column(name = "publish_time")
    private LocalDateTime publishTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Author author;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Review review;
}
