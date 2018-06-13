package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description: Redis数据库工具类
 * @author: Will.Guo
 * @create: 2018-06-13 16:41
 **/
public class JedisUtils {
    private static JedisPoolConfig config ;
    private static JedisPool pool ;
    static {
        config = new JedisPoolConfig();
        config.setMaxIdle(2);
        config.setMaxTotal(30);

        pool = new JedisPool(config, "localhost", 6379);
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void releaseJedis(Jedis jedis) {
        jedis.close();
    }

    public static void main(String[] args){
        getJedis();
    }

    public static String getString(String key) {
        Jedis jedis = getJedis();
        return jedis.get(key);
    }

    public static void setString(String key, String value, int seconds) {
        Jedis jedis = getJedis();
        jedis.append(key, value);
        jedis.expire(key, seconds);
    }
}
