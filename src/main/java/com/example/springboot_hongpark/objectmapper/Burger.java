package com.example.springboot_hongpark.objectmapper;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Burger {
    private String name;
    private int price;
    private List<String> ingredients;
}
