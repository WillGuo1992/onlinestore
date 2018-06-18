package service;

import domain.Category;

import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-18 15:19
 **/
public interface AdminCategoryServive {
    List<Category> findAll();

    void addCategory(Category category);

    Category findByCname(String cname);

    void update(Category category);

    void delete(Category category);
}
