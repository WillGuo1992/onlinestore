package service.impl;

import dao.ProductDao;
import dao.imp.ProductDaoImp;
import domain.Category;
import domain.Product;
import service.ProductService;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-13 20:58
 **/
public class ProductServiceImp implements ProductService {
    ProductDao productDao = new ProductDaoImp();
    @Override
    public List findhot() {
        return productDao.findhot();
    }

    @Override
    public List findnew() {
        return productDao.findnew();
    }

    @Override
    public Product findbyid(String pid) {
        return productDao.findbyid(pid);
    }

    @Override
    public Category getCategorybyPid(String pid) {
        return productDao.findCategorybyid(pid);
    }

}
