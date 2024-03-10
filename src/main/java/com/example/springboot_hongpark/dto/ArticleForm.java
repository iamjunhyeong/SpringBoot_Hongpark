package com.example.springboot_hongpark.dto;

import com.example.springboot_hongpark.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class ArticleForm {

    private Long id;    // id 필드 추가!!
    private String title;
    private String content;

    // id 필드 추가로 toEntity() 변경
    public Article toEntity() {
        return new Article(id, title, content);
    }
}
