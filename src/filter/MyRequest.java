package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @description:自定义request，对获得参数函数进行处理.主要是处理get方法获得值时的编码问题
 * @author: Will.Guo
 * @create: 2018-06-10 17:42
 **/
public class MyRequest extends HttpServletRequestWrapper {

    private boolean encoded = false;
    public MyRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        return super.getParameter(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> map = super.getParameterMap();
        if (!encoded) {
            if("GET".equalsIgnoreCase(super.getMethod())){
                for (Map.Entry<String,String[]> entry : map.entrySet()){
                    String[] allValues = entry.getValue();
                    for (int i = 0; i < allValues.length; i++) {
                        String encoding = super.getCharacterEncoding();
                        if (encoding == null) {
                            encoding = "UTF-8";
                        }
                        try {
                            allValues[i] = new String(allValues[i].getBytes("ISO-8859-1"),encoding);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            encoded = true ;
        }
        return  map;
    }
}
