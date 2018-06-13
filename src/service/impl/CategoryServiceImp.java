package service.impl;

import dao.CategoryDao;
import dao.imp.CategoryDaoImp;
import domain.Category;
import service.CategoryService;

import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-13 15:59
 **/
public class CategoryServiceImp implements CategoryService {
    @Override
    public List findall() {
        CategoryDao dao = new CategoryDaoImp();
        return dao.findAll();
    }
}
