package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * 返回所有目录
     * @return
     */
    public List<Category> findAll();

    /**
     * 在tab_category表查找一个分类
     * @param cid
     * @return
     */
    Category findOne(int cid);
}
