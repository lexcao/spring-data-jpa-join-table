package io.github.lexcao.jpa.entity.join;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
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

    static Specification<BookJoin> multiQuery_04(BookJoinQuery param) {
        return (root, query, cb) -> {
            if (null != param.getBookPublishTime()) {
                query.where(cb.equal(root.get("publishTime"), param.getBookPublishTime()));
            }

            if (null != param.getAuthorName()) {
                Join<Object, Object> author = root.join("author", JoinType.LEFT);
                author.on(cb.equal(author.get("name"), param.getAuthorName()));
            }

            if (null != param.getReviewScore()) {
                Join<Object, Object> review = root.join("review");
                review.on(cb.equal(review.get("score"), param.getReviewScore()));
            }
            return query.getRestriction();
        };
    }
}
