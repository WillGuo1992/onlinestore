package service.impl;

import dao.AdminCategoryDao;
import dao.imp.AdminCategoryDaoImpl;
import domain.Category;
import service.AdminCategoryServive;

import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-18 15:19
 **/
public class AdminCategoryServiveImpl implements AdminCategoryServive {

    AdminCategoryDao dao = new AdminCategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public void addCategory(Category category) {
        Category reback = dao.findByCname(category.getCname());
        if (reback == null) {
            dao.insert(category);
        }
    }

    @Override
    public Category findByCname(String cname) {
        return dao.findByCname(cname);
    }

    @Override
    public void update(Category category) {
        dao.update(category);
    }

    @Override
    public void delete(Category category) {
        dao.deleteByCname(category.getCname());
    }


}
