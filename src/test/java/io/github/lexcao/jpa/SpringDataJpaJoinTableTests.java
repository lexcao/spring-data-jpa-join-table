package io.github.lexcao.jpa;

import io.github.lexcao.jpa.entity.join.BookJoin;
import io.github.lexcao.jpa.entity.join.BookJoinQuery;
import io.github.lexcao.jpa.entity.join.BookJoinSpec;
import io.github.lexcao.jpa.repository.BookJoinRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@Sql("classpath:init.sql")
class SpringDataJpaJoinTableTests {

    @Autowired
    private BookJoinRepository repo;

    @Test
    void given_empty_query_then_return_all_data() {
        var query = BookJoinQuery.builder().build();
        var spec = BookJoinSpec.multiQuery_01(query);

        var books = repo.findAll(spec);

        assertThat(books.size()).isEqualTo(8);
    }

    /**
     * given:
     * empty query
     * then:
     * paged data
     */
    @Test
    void given_empty_query_then_paged_data() {
        var query = BookJoinQuery.builder().build();
        var spec = BookJoinSpec.multiQuery_01(query);
        var page = PageRequest.of(0, 5);

        var books = repo.findAll(spec, page);
        assertThat(books.getNumberOfElements()).isGreaterThan(0);
        books.getContent().forEach(it -> {
                assertThat(it).isNotNull();
                // 取连表之后的字段，验证是否存在懒加载
                assertThat(it.getAuthor().getName()).isNotNull();
                assertThat(it.getReview().getScore()).isNotNull();
            }
        );
    }

    @Test
    void multiQuery_01() {
        var spec = BookJoinSpec.multiQuery_01(emptyQuery());
        var page = PageRequest.of(0, 5);
        queryBySpecMethod(spec, page);
    }

    @Test
    void multiQuery_02() {
        var spec = BookJoinSpec.multiQuery_02(emptyQuery());
        var page = PageRequest.of(0, 5);
        assertThatThrownBy(() -> queryBySpecMethod(spec, page)).hasMessageContaining(
            "org.hibernate.QueryException: query specified join fetching, " +
                "but the owner of the fetched association was not present in the select list"
        );
    }

    @Test
    void multiQuery_02_fix() {
        var spec = BookJoinSpec.multiQuery_02_fix(emptyQuery());
        var page = PageRequest.of(0, 5);
        queryBySpecMethod(spec, page);
    }

    @Test
    void multiQuery_03() {
        var query = BookJoinQuery.builder()
            .authorName("Author_2")
            .build();
        var spec = BookJoinSpec.multiQuery_03(query);
        var page = PageRequest.of(0, 5);

        var result = queryBySpecMethod(spec, page);
        var givenAuthor = result.getContent().get(0).getAuthor();
        assertThat(givenAuthor.getName()).isEqualTo("Author_2");
    }

    private BookJoinQuery emptyQuery() {
        return BookJoinQuery.builder().build();
    }

    private Page<BookJoin> queryBySpecMethod(Specification<BookJoin> spec, PageRequest pageRequest) {
        var books = repo.findAll(spec, pageRequest);

        assertThat(books.getNumberOfElements()).isGreaterThan(0);

        books.getContent().forEach(it -> {
                assertThat(it).isNotNull();
                assertThat(it.getAuthor().getName()).isNotNull();
                assertThat(it.getReview().getScore()).isNotNull();
            }
        );

        return books;
    }
}
