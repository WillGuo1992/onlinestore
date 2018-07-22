package servlet;

import domain.Category;
import domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.ProductService;
import service.impl.ProductServiceImp;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;
import utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 带文件上传功能的商品添加servlet
 * @author: Will.Guo
 * @create: 2018-06-19 00:31
 **/
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            diskFileItemFactory.setSizeThreshold(3 * 1024 * 1024);
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            fileUpload.setHeaderEncoding("UTF-8");
            List<FileItem> list = fileUpload.parseRequest(req);
            Map<String, String> map = new HashMap<>();
            String fileName = null;
            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    map.put(name, value);
                } else {
                    fileName = fileItem.getName();
                    InputStream is = fileItem.getInputStream();
                    String path = this.getServletContext().getRealPath("/products/1");
                    OutputStream os = new FileOutputStream(path + "/" + fileName);
                    int len = 0;
                    byte[] buffer = new byte[1024];
                    while ((len = is.read(buffer, 0, 1024)) > -1) {
                        os.write(buffer, 0, len);
                    }
                    is.close();
                    os.close();
                }

            }
            Product product = new Product();
            BeanUtils.populate(product, map);
            product.setPid(UUIDUtils.getUUID());
            product.setPdate(new Date());
            product.setPflag(0);
            product.setPimage("products/1/" + fileName);
            Category category = new Category();

            ProductService productService = new ProductServiceImp();
            productService.save(product);
            resp.sendRedirect("AdminProductServlet?method=findAllProductsWithPage");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            doGet(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
