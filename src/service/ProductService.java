package service;

import domain.Category;
import domain.PageBean;
import domain.Product;

import java.util.Date;
import java.util.List;

public interface ProductService {
    List findhot();

    List findnew();

    Product findbyid(String pid);

    Category getCategorybyPid(String pid);

    List findByCid(String cid);

    List findPageByCid(String cid, PageBean<Product> pageBean);

    Category getCategorybyCid(String cid);
}
