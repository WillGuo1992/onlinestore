package dao;

import domain.Category;
import domain.Product;

import java.util.List;

public interface ProductDao {
    List findhot();

    List findnew();

    Product findbyid(String pid);

    Category findCategorybyid(String pid);

    List findProductsByCid(String cid);

    List findPageByCid(String cid, int startIndex, int pageSize);

    Category findCategoryByCid(String cid);

    void save(Product product);

    void updatePflagByPid(String pid, int pflag);

    List findAllByPflag(int pfalg);
}
