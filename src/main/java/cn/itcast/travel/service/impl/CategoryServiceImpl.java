package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao cd = new CategoryDaoImpl();
    private Jedis js = JedisUtil.getJedis();

    @Override
    public List<Category> findAll() {
//        Set<String> categorys = js.zrange("category", 0, -1);
        Set<Tuple> categorys = js.zrangeWithScores("category", 0, -1);
        List<Category> cs = null;

        if (categorys == null || categorys.size() == 0) {
            System.out.println("数据库查询,缓存redis");
            cs = cd.findAll();
            for (int i = 0; i < cs.size(); i++) {
                js.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        }else{
            System.out.println("从redis中查询.....");
            //4.如果不为空,将set的数据存入list
            cs = new ArrayList<Category>();
            for (Tuple tuple : categorys) {

                cs.add(new Category((int)tuple.getScore(),tuple.getElement()));
            }
        }
        return cs;
    }
}
