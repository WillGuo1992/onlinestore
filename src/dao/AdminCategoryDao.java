package dao;

import domain.Category;

import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-18 15:35
 **/
public interface AdminCategoryDao {
    public List<Category> findAll() ;

    void insert(Category category);

    Category findByCname(String cname);

    void update(Category category);

    void deleteByCname(String cname);
}
