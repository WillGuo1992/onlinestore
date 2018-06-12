package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        if (methodName == null) {
            methodName = "execute";
        }
        try {
            Method method = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            String path = (String) method.invoke(this, req, resp);
            if (path != null) {
                req.getRequestDispatcher(path).forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    空函数，便于子类复写
     */
    public String execute(HttpServletRequest req , HttpServletResponse resp){
        return null;
    }
}
