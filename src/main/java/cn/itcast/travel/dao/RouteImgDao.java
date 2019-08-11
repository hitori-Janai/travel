package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {
    /**
     * 查找图片集合 在tab_route_img
     * @param rid
     * @return
     */
    public List<RouteImg> findImgs(int rid);
}
