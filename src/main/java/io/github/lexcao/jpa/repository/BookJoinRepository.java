package io.github.lexcao.jpa.repository;

import io.github.lexcao.jpa.entity.join.BookJoin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJoinRepository extends JpaRepository<BookJoin, String>, JpaSpecificationExecutor<BookJoin> {
    @Override
    @EntityGraph(attributePaths = { "author", "review" })
    Page<BookJoin> findAll(Specification<BookJoin> spec, Pageable pageable);
}
