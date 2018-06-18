package service.impl;

import dao.AdminProductDao;
import dao.imp.AdminProductDaoImpl;
import domain.Category;
import domain.Product;
import service.AdminProductService;

import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-18 23:28
 **/
public class AdminProductServiceImpl implements AdminProductService {
    private AdminProductDao dao = new AdminProductDaoImpl();

    @Override
    public int findAllCount() {
        return dao.findAllCount();
    }

    @Override
    public List<Product> findByPage(int startIndex, int pageSize, int pflag) {
        return dao.findByPage(startIndex, pageSize,pflag);
    }

    @Override
    public List<Category> findAllCategory() {
        return dao.findAllCategory();
    }
}
