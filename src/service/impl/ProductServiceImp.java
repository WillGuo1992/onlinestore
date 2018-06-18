package service.impl;

import dao.ProductDao;
import dao.imp.ProductDaoImp;
import domain.Category;
import domain.PageBean;
import domain.Product;
import service.CategoryService;
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

    @Override
    public List findByCid(String cid) {
        return productDao.findProductsByCid(cid);
    }

    @Override
    public List findPageByCid(String cid, PageBean<Product> pageBean) {
        return productDao.findPageByCid(cid,pageBean.getStartIndex(),pageBean.getPageSize());
    }

    @Override
    public Category getCategorybyCid(String cid) {
        return productDao.findCategoryByCid(cid);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void offShow(String pid,int pflag) {
        productDao.updatePflagByPid(pid,pflag);
    }

    @Override
    public List findAllByPflag(int pfalg) {
        return productDao.findAllByPflag(pfalg);
    }

}
