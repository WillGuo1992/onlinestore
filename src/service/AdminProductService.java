package service;

import domain.Category;
import domain.Product;

import java.util.List;

public interface AdminProductService {
    int findAllCount();

    List<Product> findByPage(int startIndex, int pageSize, int pflag);

    List<Category> findAllCategory();
}
