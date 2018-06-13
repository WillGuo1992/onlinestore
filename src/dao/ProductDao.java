package dao;

import domain.Category;
import domain.Product;

import java.util.List;

public interface ProductDao {
    List findhot();

    List findnew();

    Product findbyid(String pid);

    Category findCategorybyid(String pid);
}
