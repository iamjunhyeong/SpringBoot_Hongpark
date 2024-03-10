package com.example.springboot_hongpark.repository;

import com.example.springboot_hongpark.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
