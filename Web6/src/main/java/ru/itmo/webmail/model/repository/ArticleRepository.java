package ru.itmo.webmail.model.repository;

import ru.itmo.webmail.model.domain.Article;


import java.util.List;

public interface ArticleRepository {
    Article find(long id);
    List<Article> findAll();
    List<Article> findByUserId(long userId);
    void update(long articleId, long type);
    void save(Article article);
}
