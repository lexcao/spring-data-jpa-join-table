package io.github.lexcao.jpa.entity.join;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class BookJoinQuery {
    private String authorName;
    private Integer reviewScore;
    private LocalDateTime bookPublishTime;
}
