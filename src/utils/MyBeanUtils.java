package utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.DbUtils;

import java.util.Date;
import java.util.Map;

/**
 * @description: 增强DBUtils，主要是采用反射方法增加日期转换功能
 * @author: Will.Guo
 * @create: 2018-06-10 16:01
 **/
public class MyBeanUtils {
    public static <T> T populate (Class<T> beanClass , Map<String,String[]> properties){
        try {
            T bean = beanClass.newInstance();
            DateConverter dateConverter = new DateConverter();
            dateConverter.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
            ConvertUtils.register(dateConverter,Date.class);
            BeanUtils.populate(bean,properties);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;

    }
}
