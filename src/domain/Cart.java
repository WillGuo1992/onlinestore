package domain;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 购物车
 * @author: Will.Guo
 * @create: 2018-06-14 19:39
 **/
public class Cart {

    private Map<String, CartItem> map = new HashMap<String, CartItem>();
    private double total;

    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addCart(Product product , int count){
        String pid = product.getPid();
        if(!map.containsKey(pid)){
            CartItem item = new CartItem();
            item.setCount(count);
            item.setProduct(product);
            map.put(pid, item);
        } else {
            CartItem item = map.get(pid);
            int oldCount = item.getCount();
            item.setCount(oldCount + count);
            map.put(pid, item);
        }
    }

    public void removeOneItem(String pid) {
        this.map.remove(pid);
    }

    public void removeAll() {
        map.clear();
    }

    public double getTotal() {
        total = 0;
        for (Map.Entry<String,CartItem> entry : map.entrySet()) {
            CartItem cartItem = entry.getValue();
            total += cartItem.getItemTotal();
        }
        return total;
    }

    public List<CartItem> getCartItems() {
        List<CartItem> list = new ArrayList<>();
        for (Map.Entry<String,CartItem> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
