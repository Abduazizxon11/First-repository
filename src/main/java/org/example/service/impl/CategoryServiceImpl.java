package org.example.service.impl;

import org.example.model.Category;
import org.example.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    List<Category> categories = new ArrayList<>();
    @Override
    public void create(String name, int id) {
        Category category = new Category();
        category.setId(category.getId());
        category.setName(category.getName());
        categories.add(category);
    }

    @Override
    public Category get(int id) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id){
                return categories.get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Category temp = null;
        for (Category category:categories) {
            if (category.getId() == id){
                temp = category;
            }
        }if (temp != null){
            categories.remove(temp);
        }
    }

    @Override
    public List<Category> getAll() {
        return categories;
    }
}
