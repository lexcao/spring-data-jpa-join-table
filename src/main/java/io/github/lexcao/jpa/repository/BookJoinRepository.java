package io.github.lexcao.jpa.repository;

import io.github.lexcao.jpa.entity.join.BookJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJoinRepository extends JpaRepository<BookJoin, String>, JpaSpecificationExecutor<BookJoin> {
}
