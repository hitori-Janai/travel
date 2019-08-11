package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category";
        List<Category> categories = template.query(sql, new BeanPropertyRowMapper<>(Category.class));
        return categories;
    }

    @Override
    public Category findOne(int cid) {
        String sql = "select * from tab_category where cid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Category.class), cid);
    }
}
