package org.example.service;

import org.example.model.Category;

import java.util.List;

public interface CategoryService {
    void create(String name, int id);
    Category get(int id);
    void delete(int id);
    List<Category> getAll();
}
