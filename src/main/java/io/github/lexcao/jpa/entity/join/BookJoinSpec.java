package io.github.lexcao.jpa.entity.join;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.LinkedList;

public interface BookJoinSpec {

    static Specification<BookJoin> multiQuery_01(BookJoinQuery param) {
        return (root, query, cb) -> {
            var predicates = new LinkedList<Predicate>();

            root.join("author");
            root.join("review");

            if (null != param.getBookPublishTime()) {
                predicates.add(cb.equal(root.get("publishTime"), param.getBookPublishTime()));
            }

            if (null != param.getAuthorName()) {
                predicates.add(cb.equal(root.get("author.name"), param.getAuthorName()));
            }

            if (null != param.getReviewScore()) {
                predicates.add(cb.equal(root.get("review.score"), param.getReviewScore()));
            }

            query.where(predicates.toArray(new Predicate[0]));

            return query.getRestriction();
        };
    }

    static Specification<BookJoin> multiQuery_02(BookJoinQuery param) {
        return (root, query, cb) -> {
            var predicates = new LinkedList<Predicate>();

            root.fetch("author");
            root.fetch("review");

            if (null != param.getBookPublishTime()) {
                predicates.add(cb.equal(root.get("publishTime"), param.getBookPublishTime()));
            }

            if (null != param.getAuthorName()) {
                predicates.add(cb.equal(root.get("author.name"), param.getAuthorName()));
            }

            if (null != param.getReviewScore()) {
                predicates.add(cb.equal(root.get("review.score"), param.getReviewScore()));
            }

            query.where(predicates.toArray(new Predicate[0]));

            return query.getRestriction();
        };
    }

    static Specification<BookJoin> multiQuery_02_fix(BookJoinQuery param) {
        return (root, query, cb) -> {
            var predicates = new LinkedList<Predicate>();

            if (Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType())) {
                root.join("author");
                root.join("review");
            } else {
                root.fetch("author");
                root.fetch("review");
            }

            if (null != param.getBookPublishTime()) {
                predicates.add(cb.equal(root.get("publishTime"), param.getBookPublishTime()));
            }

            if (null != param.getAuthorName()) {
                predicates.add(cb.equal(root.get("author.name"), param.getAuthorName()));
            }

            if (null != param.getReviewScore()) {
                predicates.add(cb.equal(root.get("review.score"), param.getReviewScore()));
            }

            query.where(predicates.toArray(new Predicate[0]));

            return query.getRestriction();
        };
    }

    static Specification<BookJoin> multiQuery_03(BookJoinQuery param) {
        return (root, query, cb) -> {
            var predicates = new LinkedList<Predicate>();

            if (Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType())) {
                root.join("author");
                root.join("review");
            } else {
                root.fetch("author");
                root.fetch("review");
            }

            if (null != param.getBookPublishTime()) {
                predicates.add(cb.equal(root.get("publishTime"), param.getBookPublishTime()));
            }

            if (null != param.getAuthorName()) {
                predicates.add(cb.equal(root.get("author").get("name"), param.getAuthorName()));
            }

            if (null != param.getReviewScore()) {
                predicates.add(cb.equal(root.get("review").get("score"), param.getReviewScore()));
            }

            query.where(predicates.toArray(new Predicate[0]));

            return query.getRestriction();
        };
    }
}
