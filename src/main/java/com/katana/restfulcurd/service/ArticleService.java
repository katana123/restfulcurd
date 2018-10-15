package com.katana.restfulcurd.service;

import com.katana.restfulcurd.dao.ArticleRepository;
import com.katana.restfulcurd.entity.Article;
import com.katana.restfulcurd.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Cacheable(cacheNames = "article")
    public Page<Article> findAllPageable(Integer page) {
        return articleRepository.findAll(PageRequest.of(page, 3));
    }

    public List<Article> leftJoin() {
        Specification<Article> spec = new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                Join<Article, Comment> join = root.join("commentSet", JoinType.LEFT);
                cq.groupBy(root.get("id"));
                return cb.and(list.toArray(new Predicate[list.size()]));
            }
        };

        List<Article> articleList = articleRepository.findAll(spec);
        return articleList;
    }
}
