package dao;

import domain.Category;
import domain.Product;

import java.util.List;

public interface AdminProductDao {
    int findAllCount();

    List<Product> findByPage(int startIndex, int pageSize, int pflag);

    List<Category> findAllCategory();
}
